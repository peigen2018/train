package com.pg.train.java.socket;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.URLEncoder;

public class HTTPTools {
    public static void main(String[] args) {
        try {
            // 提交的数据
            String data = URLEncoder.encode("name", "UTF-8") + "="
                    + URLEncoder.encode("老紫竹", "UTF-8");
            data += "&" + URLEncoder.encode("message", "UTF-8") + "="
                    + URLEncoder.encode("欢迎光临JAVA世纪网", "UTF-8");
            // 建立连接
            String hostname = "test.meitanjianghu.com";
            int port = 80;
            InetAddress addr = InetAddress.getByName(hostname);
            Socket socket = new Socket(addr, port);
            // 发送数据头
            String path = "/";
            BufferedWriter wr = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),
                    "UTF8"));
            wr.write("GET " + path + " HTTP/1.0\r\n");
            wr.write("Host: ");
            wr.write("Content-Length: " + data.length() + "\r\n");
            wr.write("Content-Type: application/x-www-form-urlencoded\r\n");
            wr.write("\r\n"); // 以空行作为分割
            // 发送数据
            wr.write(data);
            wr.flush();
            // 读取返回信息
            BufferedReader rd = new BufferedReader(new InputStreamReader(socket.getInputStream(),
                    "UTF-8"));
            String line;
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
            wr.close();
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
