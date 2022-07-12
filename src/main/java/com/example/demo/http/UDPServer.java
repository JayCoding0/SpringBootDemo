package com.example.demo.http;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Jay
 * @description
 * @date Created in 2022/6/2 1:30 上午
 */
public class UDPServer {
    public static void main(String[] args) throws IOException {

        int serverPort = 8888;
        DatagramSocket ds = null;
        DatagramPacket sendDp;
        DatagramPacket receiveDp;
        ds = new DatagramSocket(serverPort);
        System.out.println("服务器创建成功！端口号为： " + ds.getLocalPort());

        byte[] buf = new byte[1024];
        receiveDp = new DatagramPacket(buf, buf.length);
        ds.receive(receiveDp);
        System.out.println("收到： " + receiveDp.getSocketAddress());
        System.out.println("Data is " + new String(receiveDp.getData(), 0, receiveDp.getLength()));

        InetAddress clientIp = receiveDp.getAddress();
        int clientPort = receiveDp.getPort();

        String respose = "OK,收到来自星星的你的祝福";
        byte []bData = respose.getBytes();
        sendDp = new DatagramPacket(bData, bData.length, clientIp, clientPort);
        ds.send(sendDp);
        ds.close();

    }
}
