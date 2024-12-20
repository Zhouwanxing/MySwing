package com.zwx.mqtt;

import com.zwx.utils.AESUtil;
import com.zwx.utils.RuntimeData;
import com.zwx.view.MainFrame;
import org.eclipse.paho.client.mqttv3.*;

public class MQTTClient {
    public static void connect(String broker, String topic, MainFrame mainFrame) {
        try {
            MqttClient client = new MqttClient(broker, MqttClient.generateClientId());
            client.connect();
            client.subscribe(topic);
            client.setCallback(new MqttCallback() {
                @Override
                public void connectionLost(Throwable cause) {
                    mainFrame.updateData("连接丢失！");
                }

                @Override
                public void messageArrived(String topic, MqttMessage message) {
                    String data = new String(message.getPayload());
                    try {
                        mainFrame.updateData("接收到消息: " + AESUtil.decryptByMyKey(data, RuntimeData.getInstance().getSwingConfig().getMessageSecret()));
                    } catch (Exception e) {
                        mainFrame.updateData("接收到消息: " + data);
                    }
                }

                @Override
                public void deliveryComplete(IMqttDeliveryToken token) {
                }
            });
            mainFrame.updateData("成功连接到 MQTT 服务器\n");
        } catch (MqttException e) {
            mainFrame.updateData("连接失败: " + e.getMessage());
        }
    }
}