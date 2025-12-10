package com.zl.frame;

import com.zl.dao.UserlogDao;
import com.zl.model.Userlog;

import javax.swing.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    public LoginFrame() {
        setLayout(null);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int width = screenSize.width;
        int height = screenSize.height;
        setBounds(width / 2 - 200, height / 2 - 200, 400, 400);

        JLabel titleLabel = new JLabel("Influenza Information Management System", SwingConstants.CENTER);
        titleLabel.setBounds(0, 20, 400, 30);
        Font font = new Font("Arial", Font.BOLD, 17);
        titleLabel.setFont(font);
        add(titleLabel);

        JLabel userNameLabel = new JLabel("account:");
        userNameLabel.setBounds(60, 80, 100, 30);
        add(userNameLabel);

        JTextField userNameField = new JTextField();
        userNameField.setText("admin");
        userNameField.setBounds(120, 80, 200, 30);
        add(userNameField);

        JLabel pwdLabel = new JLabel("password:");
        pwdLabel.setBounds(60, 140, 100, 30);
        add(pwdLabel);

        JPasswordField pwdField = new JPasswordField();
        pwdField.setText("admin123");
        pwdField.setBounds(120, 140, 200, 30);
        add(pwdField);


        JButton loginBtn = new JButton("log in");
        loginBtn.setBounds(100, 240, 200, 30);
        add(loginBtn);

        loginBtn.addActionListener(e -> {

            String userName = userNameField.getText();
            if (userName.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please input account.");
                return;
            }
            String password = pwdField.getText();
            if (password.length() == 0) {
                JOptionPane.showMessageDialog(null, "Please input password.");
                return;
            }

            Userlog userlog = UserlogDao.login(userName, password);
            if (userlog == null) {
                JOptionPane.showMessageDialog(null, "The user account is incorrect.");
            }else {
                setVisible(false);
                new UserlogFrame();
            }
        });
    }
}
