package com.example.demo.scoket;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jay
 * @description
 * @date Created in 2022/6/2 12:09 上午
 */
public class TcpSocketServer {
    public static void main(String[] args) throws IOException {

        //        // 创建服务端socket 绑定端口
        //        ServerSocket serverSocket = new ServerSocket();
        //
        //        //绑定ip
        //        serverSocket = new ServerSocket(8080, 10, InetAddress.getByName("127.0.0.1"));
        //        // 创建客户端socket 用户下面接收客户端socket对象
        //        Socket socket = new Socket();
        //        System.out.println("等待客户端连接...");
        //        //循环监听等待客户端的连接
        //
        //        // 监听客户端  没有接受到数据才会停在此处 接受到往下执行
        //        socket = serverSocket.accept();
        //        InputStream inputStream = socket.getInputStream();//得到一个输入流，接收客户端传递的信息
        //
        //        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//提高效率，将自己字节流转为字符流
        //
        //        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//加入缓冲区
        //
        //        String temp = null;
        //
        //        String info = "";
        //
        //        while ((temp = bufferedReader.readLine()) != null) {
        //
        //            info += temp;
        //
        //            System.out.println("已接收到客户端连接");
        //
        //            System.out.println("服务端接收到客户端信息：" + info + ",当前客户端ip为：" + socket.getInetAddress().getHostAddress());
        //
        //        }
        //
        //        OutputStream outputStream = socket.getOutputStream();//获取一个输出流，向服务端发送信息
        //
        //        PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流
        //
        //        printWriter.print("你好，服务端已接收到您的信息");
        //
        //        printWriter.flush();
        //
        //        socket.shutdownOutput();//关闭输出流
        //
        //        //关闭相对应的资源
        //
        //        printWriter.close();
        //
        //        outputStream.close();
        //
        //        bufferedReader.close();
        //
        //        inputStream.close();
        //
        //      //  socket.close();


        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("服务端已启动，等待客户端连接..");

        while (true) {

            Socket socket = serverSocket.accept();// 侦听并接受到此套接字的连接,返回一个Socket对象

            SocketThread socketThread = new SocketThread(socket);

            socketThread.start();
        }
    }

}

