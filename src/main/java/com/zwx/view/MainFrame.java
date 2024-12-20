package com.zwx.view;

import com.zwx.mqtt.MQTTClient;
import com.zwx.utils.RuntimeData;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private final JTextArea dataDisplay;

    public MainFrame() {
        setTitle("主界面");
        Image icon = Toolkit.getDefaultToolkit().getImage(
                getClass().getResource("/images/jerry.png")
        );
        setIconImage(icon);
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel mainPanel = new JPanel(new BorderLayout());

        JLabel welcomeLabel = new JLabel("欢迎进入主界面！", JLabel.CENTER);
//        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(welcomeLabel, BorderLayout.NORTH);

        dataDisplay = new JTextArea();
        dataDisplay.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(dataDisplay);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);

        MQTTClient.connect(RuntimeData.getInstance().getSwingConfig().getBroker(), RuntimeData.getInstance().getSwingConfig().getTopic(), this);
    }

    public void updateData(String message) {
        dataDisplay.append(message + "\n");
    }
}