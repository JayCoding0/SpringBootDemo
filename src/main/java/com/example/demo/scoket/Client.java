package com.example.demo.scoket;

import java.io.*;
import java.net.Socket;

/**
 * @author Jay
 * @description
 * @date Created in 2022/6/2 12:17 上午
 */
public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 8888);

        //根据输入输出流和服务端连接

        OutputStream outputStream = socket.getOutputStream();//获取一个输出流，向服务端发送信息

        PrintWriter printWriter = new PrintWriter(outputStream);//将输出流包装成打印流

        printWriter.print("服务端你好，我是Balla_兔子");

        printWriter.flush();

        socket.shutdownOutput();//关闭输出流

        InputStream inputStream = socket.getInputStream();//获取一个输入流，接收服务端的信息

        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);//包装成字符流，提高效率

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);//缓冲区

        String info = "";

        String temp = null;//临时变量

        while ((temp = bufferedReader.readLine()) != null) {

            info += temp;

            System.out.println("客户端接收服务端发送信息：" + info);

        }

        //关闭相对应的资源

        bufferedReader.close();

        inputStream.close();

        printWriter.close();

        outputStream.close();


    }
}
