package com.example.demo.http;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Jay
 * @description
 * @date Created in 2022/6/2 12:47 上午
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建服务器套接字
        ServerSocket serverSocket = new ServerSocket(8888);
        while (true){
            //获取发出请求的客户端套接字
            Socket accept = serverSocket.accept();

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
            bufferedWriter.write("HTTP/1.1 200 OK");
            bufferedWriter.newLine();
            bufferedWriter.write("Content-Type:text/html; charset=utf-8");
            bufferedWriter.newLine();
            bufferedWriter.write("Content-Length:20");
            bufferedWriter.newLine();
            bufferedWriter.newLine();
            bufferedWriter.write("<h1>Hello,World!黑哥</h1>");
            bufferedWriter.flush();



            InputStream inputStream = accept.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);

            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuilder info = new StringBuilder();

            String temp = null;//临时变量


            int len = 100;
            while((len = bufferedReader.read()) != -1){

                info.append((char) len);
            }
            System.out.println("http报文:"+info);
            bufferedReader.close();

            inputStream.close();

            accept.close();
        }

    }
}
