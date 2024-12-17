package com.zwx.view;

import com.zwx.mqtt.MQTTClient;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    private JTextArea dataDisplay;

    public MainFrame() {
        setTitle("主界面");
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

        MQTTClient.connect("tcp://broker.emqx.io:1883", "testTopic", this);
    }

    public void updateData(String message) {
        dataDisplay.append(message + "\n");
    }
}