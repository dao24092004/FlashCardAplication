package com.flashcard.main;

import com.flashcard.model.ModelUser;
import com.flashcard.componet.PanelSlide;
import java.awt.Color;
import javax.swing.JPanel;

public class UserPage extends javax.swing.JFrame {

    private final ModelUser user;
    private final PanelSlide panelSlide;

    public UserPage(ModelUser user) {
        this.user = user;
        initComponents();
        getContentPane().setBackground(Color.WHITE); // Đặt màu nền trắng
        lbUser.setText("Welcome, " + user.getUserName() + "uẻ"); // Hiển thị tên người dùng
        
        // Cấu hình PanelSlide
        panelSlide = new PanelSlide();
        panelSlide.setSize(400, 300);
        panelSlide.setAnimate(5);
        
        // Khởi tạo các panel con
        JPanel panel1 = createPanel(Color.RED);
        JPanel panel2 = createPanel(Color.BLUE);
        JPanel panel3 = createPanel(Color.GREEN);
        
        // Thêm panel con vào PanelSlide
        panelSlide.init(panel1, panel2, panel3);

        // Thêm PanelSlide vào UserPage
        add(panelSlide);
    }

    // Phương thức tạo panel với màu sắc tùy chỉnh
    private JPanel createPanel(Color color) {
        JPanel panel = new JPanel();
        panel.setBackground(color);
        return panel;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbUser = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbUser.setFont(new java.awt.Font("sansserif", 1, 18));
        lbUser.setForeground(new java.awt.Color(77, 77, 77));
        lbUser.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(518, 518, 518)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(543, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(311, 311, 311)
                .addComponent(lbUser, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(350, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public static void main(ModelUser user) {
        java.awt.EventQueue.invokeLater(() -> new UserPage(user).setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbUser;
    // End of variables declaration//GEN-END:variables
}
