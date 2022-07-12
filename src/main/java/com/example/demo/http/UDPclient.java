package com.example.demo.http;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author Jay
 * @description
 * @date Created in 2022/6/2 1:33 上午
 */
public class UDPclient {

    public static void main(String[] args) throws Exception {

        DatagramSocket ds = null;//
        DatagramPacket sendDp;
        DatagramPacket receiveDp;
        String serverHost = "127.0.0.1";
        int serverPort = 8888;
        ds = new DatagramSocket();
        byte[] buf = "hello,UDP协议！来自星星的问候……".getBytes();
        sendDp = new DatagramPacket(buf,buf.length, InetAddress.getByName(serverHost),serverPort);
        ds.send(sendDp);

        byte[] bufr = new byte[1024];
        receiveDp = new DatagramPacket(bufr,bufr.length);
        ds.receive(receiveDp);

        byte[] response = receiveDp.getData();
        int len = receiveDp.getLength();
        String s = new String(response,0,len);
        System.out.println("服务器端反馈为： "+s);
        ds.close();
    }
}
