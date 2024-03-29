package com.example.demo.tool.websocket;


import lombok.extern.slf4j.Slf4j;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

import java.net.URI;


/**
 * @author Jay
 * @description
 * @date Created in 2019/7/2 16:31
 */
@Slf4j
public class Test {


    public static void main(String[] args) throws Exception {
        MyWebSocketClient myClient =
                new MyWebSocketClient(new URI("ws://127.0.0.1:9000/webSocket"));
        // 往websocket服务端发送数据
        myClient.connect();
        Thread.sleep(3000);
        log.info("已连接成功");
        myClient.send("测试连接");

        CloseableHttpClient httpclient = HttpClients.createDefault();

    }
}
