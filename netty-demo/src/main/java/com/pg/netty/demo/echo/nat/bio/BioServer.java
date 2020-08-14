package com.pg.netty.demo.echo.nat.bio;

import io.netty.util.CharsetUtil;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    final private int port;

    public BioServer(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        final ServerSocket serverSocket = new ServerSocket(this.port);
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            System.out.println("connect client socket");
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try (OutputStream outputStream = clientSocket.getOutputStream()) {
                        outputStream.write("hello world".getBytes(CharsetUtil.UTF_8));
                        outputStream.flush();
                        clientSocket.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }


                }
            });
        }
    }
}
