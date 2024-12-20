package com.zwx.view;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zwx.entity.SwingConfig;
import com.zwx.utils.RuntimeData;

import javax.swing.*;

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

        loginButton.addActionListener(e -> {
            String username = userText.getText().trim();
            String password = new String(passwordText.getPassword()).trim();
            if (username.isEmpty() || password.isEmpty()) {
                JOptionPane.showMessageDialog(panel, "请输入用户名或密码", "提醒", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            try {
                String s = HttpUtil.get("https://goldtask.onrender.com/page/user/login?username=" + username + "&password=" + password + "&dev=swing");
                JSONObject res = JSONUtil.parseObj(s);
                if (res.getInt("code") != 200) {
                    JOptionPane.showMessageDialog(panel, "用户名或密码错误！", "提醒", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                RuntimeData.getInstance().setSwingConfig(res.getJSONObject("data").get("swingConfig", SwingConfig.class));
                dispose();
                new MainFrame();
            } catch (Exception ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(panel, "网络异常", "1", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        setVisible(true);
    }
}