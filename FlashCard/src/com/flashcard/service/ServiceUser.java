package com.flashcard.service;

import com.flashcard.connection.DatabaseConnection;
import com.flashcard.model.ModelLogin;
import com.flashcard.model.ModelUser;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Random;

public class ServiceUser {

    private final Connection con;

    public ServiceUser() {
        con = DatabaseConnection.getInstance().getConnection();
        if (con != null) {
            System.out.println("Database connection established successfully.");
        } else {
            System.out.println("Failed to establish database connection.");
        }
    }
    public ModelUser login(ModelLogin login) throws SQLException {
        ModelUser data = null;
        String email = login.getEmail().trim();
        String password = login.getPassword().trim();

        // Kiểm tra email và password không được để trống
        if (email.isEmpty() || password.isEmpty()) {
            System.out.println("Email và mật khẩu không được để trống.");
            return null;
        }

        System.out.println("Đang thực hiện đăng nhập với Email: " + email);

        String sql = "SELECT UserID, UserName, Email, Role FROM [tbl_user] WHERE Email = ? AND Password = ?";
        try (PreparedStatement p = con.prepareStatement(sql)) {
            p.setString(1, email);
            p.setString(2, password);

            try (ResultSet r = p.executeQuery()) {
                if (r.next()) {
                    int userID = r.getInt("UserID");
                    String userName = r.getString("UserName");
                    String role = r.getString("Role"); // Lấy vai trò từ kết quả truy vấn

                    // Khởi tạo đối tượng ModelUser với vai trò
                    data = new ModelUser(userID, userName, email,role);
                    System.out.println("Đã tìm thấy người dùng: " + email + ", Vai trò: " + role);

                    // Kiểm tra quyền của người dùng
                    if ("admin".equalsIgnoreCase(role)) {
                        System.out.println("Đăng nhập với vai trò admin.");
                        // Thực hiện chuyển hướng đến trang admin
                    } else {
                        System.out.println("Đăng nhập với vai trò người dùng.");
                        // Thực hiện chuyển hướng đến trang người dùng
                    }
                } else {
                    System.out.println("Không tìm thấy người dùng với thông tin đăng nhập đã cung cấp.");
                }
            }
        } catch (SQLException e) {
            System.out.println("Lỗi SQL trong quá trình đăng nhập: " + e.getMessage());
            e.printStackTrace();
        }

        return data;
    }




    public void insertUser(ModelUser user) throws SQLException {
        // Sử dụng dấu ngoặc vuông cho tên bảng
        PreparedStatement p = con.prepareStatement("INSERT INTO [tbl_user] (UserName, Email, Password, VerifyCode) VALUES (?, ?, ?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
        String code = generateVerifyCode();
        p.setString(1, user.getUserName());
        p.setString(2, user.getEmail());
        p.setString(3, user.getPassword());
        p.setString(4, code);
        p.executeUpdate(); // Sử dụng executeUpdate() cho INSERT
        
        ResultSet r = p.getGeneratedKeys();
        if (r.next()) {
            int userID = r.getInt(1);
            user.setUserID(userID);
            user.setVerifyCode(code);
        }
        r.close();
        p.close();
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  // Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        // Sử dụng dấu ngoặc vuông cho tên bảng
        PreparedStatement p = con.prepareStatement("SELECT UserID FROM [tbl_user] WHERE VerifyCode = ?");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.next()) { // Sử dụng next() để kiểm tra dữ liệu
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateUser(String user) throws SQLException {
        boolean duplicate = false;
        // Sử dụng dấu ngoặc vuông cho tên bảng
        PreparedStatement p = con.prepareStatement("SELECT UserID FROM [tbl_user] WHERE UserName = ? AND Status = 'Verified'");
        p.setString(1, user);
        ResultSet r = p.executeQuery();
        if (r.next()) { // Sử dụng next() để kiểm tra dữ liệu
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public boolean checkDuplicateEmail(String email) throws SQLException {
        boolean duplicate = false;
        // Sử dụng dấu ngoặc vuông cho tên bảng
        PreparedStatement p = con.prepareStatement("SELECT UserID FROM [tbl_user] WHERE Email = ? AND Status = 'Verified'");
        p.setString(1, email);
        ResultSet r = p.executeQuery();
        if (r.next()) { // Sử dụng next() để kiểm tra dữ liệu
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }

    public void doneVerify(int userID) throws SQLException {
        // Sử dụng dấu ngoặc vuông cho tên bảng
        PreparedStatement p = con.prepareStatement("UPDATE [tbl_user] SET VerifyCode = '', Status = 'Verified' WHERE UserID = ?");
        p.setInt(1, userID);
        p.executeUpdate(); // Sử dụng executeUpdate() cho UPDATE
        p.close();
    }

    public boolean verifyCodeWithUser(int userID, String code) throws SQLException {
        boolean verify = false;
        // Sử dụng dấu ngoặc vuông cho tên bảng
        PreparedStatement p = con.prepareStatement("SELECT UserID FROM [tbl_user] WHERE UserID = ? AND VerifyCode = ?");
        p.setInt(1, userID);
        p.setString(2, code);
        ResultSet r = p.executeQuery();
        if (r.next()) { // Sử dụng next() để kiểm tra dữ liệu
            verify = true;
        }
        r.close();
        p.close();
        return verify;
    }
}
