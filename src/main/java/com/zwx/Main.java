package com.zwx;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        // 创建登录窗口
        JFrame loginFrame = new JFrame("登录窗口");
        loginFrame.setSize(400, 200);
        loginFrame.setResizable(false);  // 登录窗口
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        loginFrame.add(panel);
        placeComponents(panel, loginFrame);

        loginFrame.setVisible(true);
    }

    private static void placeComponents(JPanel panel, JFrame loginFrame) {
        panel.setLayout(null);

        // 用户名输入
        JLabel userLabel = new JLabel("用户名:");
        userLabel.setBounds(50, 30, 80, 25);
        panel.add(userLabel);

        JTextField userText = new JTextField(20);
        userText.setBounds(150, 30, 165, 25);
        panel.add(userText);

        // 密码输入
        JLabel passwordLabel = new JLabel("密码:");
        passwordLabel.setBounds(50, 70, 80, 25);
        panel.add(passwordLabel);

        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(150, 70, 165, 25);
        panel.add(passwordText);

        // 登录按钮
        JButton loginButton = new JButton("登录");
        loginButton.setBounds(150, 110, 80, 25);
        panel.add(loginButton);

        // 登录按钮事件
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userText.getText();
                String password = new String(passwordText.getPassword());

                if ("admin".equals(username) && "1234".equals(password)) {
//                    JOptionPane.showMessageDialog(panel, "登录成功！");
                    loginFrame.dispose();  // 关闭登录窗口
                    showMainWindow();     // 打开主界面
                } else {
                    JOptionPane.showMessageDialog(panel, "用户名或密码错误！");
                }
            }
        });
    }

    // 主界面方法
    private static void showMainWindow() {
        JFrame mainFrame = new JFrame("主界面");
        mainFrame.setSize(500, 400);
        mainFrame.setResizable(false);  // 登录窗口

        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JLabel welcomeLabel = new JLabel("欢迎进入主界面！", JLabel.CENTER);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(welcomeLabel, BorderLayout.CENTER);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);
    }
}