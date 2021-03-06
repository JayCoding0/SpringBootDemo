package com.example.demo.tool.mqtt;

import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

public class ServerMQTT {

    //tcp://MQTT安装的服务器地址:MQTT定义的端口号
    //public static final String HOST = "tcp://212.64.98.231:1884";
    public static final String HOST = "tcp://39.100.143.29:1883";
    //定义一个主题
    public static final String TOPIC = "test";
    //定义MQTT的ID，可以在MQTT服务配置中指定
    private static final String clientid = "test11221";

    private MqttClient client;
    private MqttTopic topic11;
    private String userName = "test-superadmin";
    private String passWord = "admin";

    private MqttMessage message;

    /**
     * 构造函数
     *
     * @throws MqttException
     */
    public ServerMQTT() throws MqttException {
        // MemoryPersistence设置clientid的保存形式，默认为以内存保存
        client = new MqttClient(HOST, clientid, new MemoryPersistence());
        connect();
    }

    /**
     * 用来连接服务器
     */
    private void connect() {
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(userName);
        options.setPassword(passWord.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(1000000);
        // 设置会话心跳时间
        options.setKeepAliveInterval(100);
        try {
            client.setCallback(new PushCallback());
            client.connect(options);
            topic11 = client.getTopic(TOPIC);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @param topic
     * @param message
     * @throws MqttPersistenceException
     * @throws MqttException
     */
    public void publish(MqttTopic topic, MqttMessage message) throws MqttPersistenceException,
            MqttException {
        MqttDeliveryToken token = topic.publish(message);
        token.waitForCompletion();
        System.out.println("message is published completely! "
                + token.isComplete());
    }

    /**
     * 启动入口
     *
     * @param args
     * @throws MqttException
     */
    public static void main(String[] args) throws MqttException {

        //        String res;
        //        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss,SS");
        //        long lt = new Long(1483426181100L);
        //        Date date = new Date(lt);
        //        res = simpleDateFormat.format(date);
        //
        //        System.out.println(res);
        //

        //        boolean b = "timeout".equalsIgnoreCase("TImeOut");
        //        System.out.println(b);
                ServerMQTT server = new ServerMQTT();
                server.message = new MqttMessage();
                server.message.setQos(1);
                server.message.setRetained(true);
                server.message.setPayload("hello,topic11".getBytes());

                server.publish(server.topic11, server.message);

                System.out.println(server.message.isRetained() + "------ratained状态");
//        try {
//            test();
//        } catch (Exception e) {
//            System.out.println("已被处理");
//        }
//        System.out.println("--------------------");
    }


}
