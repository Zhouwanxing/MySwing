package com.zwx;

import com.zwx.view.LoginFrame;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

public class AppLauncher {
    public static void main(String[] args) {
        if (!SystemTray.isSupported()) {
            System.out.println("系统托盘不支持");
            return;
        }

        SystemTray tray = SystemTray.getSystemTray();
        // 从资源目录加载图标
        URL imageUrl = AppLauncher.class.getClassLoader().getResource("images/jerry.png");
        if (imageUrl == null) {
            System.out.println("图标文件未找到");
            return;
        }
        Image image = Toolkit.getDefaultToolkit().getImage(imageUrl);
        TrayIcon trayIcon = new TrayIcon(image, "托盘图标示例");
        trayIcon.setImageAutoSize(true);

        // 创建右键菜单
        PopupMenu popupMenu = new PopupMenu();
        // 添加菜单项
        MenuItem openItem = new MenuItem("open");
        MenuItem exitItem = new MenuItem("exit");

      /*  Font font = new Font("微软雅黑", Font.PLAIN, 12);
        openItem.setFont(font);
        exitItem.setFont(font);*/

        openItem.addActionListener(e -> {
            System.out.println("打开操作");
            // 这里可以添加打开窗口或其他操作的代码
        });

        exitItem.addActionListener(e -> {
            System.out.println("退出操作");
            System.exit(0);
        });

        popupMenu.add(openItem);
        popupMenu.addSeparator(); // 添加分隔线
        popupMenu.add(exitItem);

        // 将菜单设置到托盘图标
        trayIcon.setPopupMenu(popupMenu);

        // 添加鼠标点击事件
        trayIcon.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                System.out.println("托盘图标被点击");
            }
        });

        // 添加托盘图标
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            System.out.println("无法添加托盘图标");
            e.printStackTrace();
        }
        new LoginFrame();
    }
}