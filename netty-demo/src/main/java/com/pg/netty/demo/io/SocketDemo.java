package com.pg.netty.demo.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketDemo {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8090);


        while (true){
            Socket client = serverSocket.accept();
            new Thread(()->{


            });
        }
    }
}
