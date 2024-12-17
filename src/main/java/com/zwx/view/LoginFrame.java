package com.zwx.view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        setTitle("登录窗口");
        setSize(400, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(50, 30, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 30, 165, 25);
        panel.add(userText);

        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(50, 70, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 70, 165, 25);
        panel.add(passwordText);

        JButton loginButton = new JButton("登录");
        loginButton.setBounds(150, 110, 80, 25);
        panel.add(loginButton);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());
                if ("admin".equals(username) && "1234".equals(password)) {
                    dispose();
                    new MainFrame();
                } else {
                    JOptionPane.showMessageDialog(panel, "用户名或密码错误！", "1", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        setVisible(true);
    }
}