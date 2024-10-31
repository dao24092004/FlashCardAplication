package com.FlashCard.model;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        // Tạo đường dẫn tới ảnh
        Path imagePath = Paths.get("src/com/FlashCard/icon/" + icon + ".png");

        // Kiểm tra sự tồn tại của file
        if (!Files.exists(imagePath)) {
            System.err.println("Không tìm thấy tệp hình ảnh: " + imagePath.toString());
            return new ImageIcon(getClass().getResource("/com/FlashCard/icon/default.png"));
        }

        // Trả về ImageIcon từ đường dẫn
        return new ImageIcon(imagePath.toAbsolutePath().toString());
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
