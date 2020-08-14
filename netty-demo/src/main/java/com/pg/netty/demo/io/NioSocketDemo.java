package com.pg.netty.demo.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.LinkedList;
import java.util.List;

public class NioSocketDemo {
    public static void main(String[] args) throws IOException {
        List<SocketChannel> channels = new LinkedList<>();


        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(9090));
        serverSocket.configureBlocking(false);
        while (true) {
            SocketChannel client = serverSocket.accept();

            if(client==null){
                System.out.println("skip-----" );
                continue;
            }

            client.configureBlocking(false);
            int port = client.socket().getPort();

            System.out.println("client port " + port);

            channels.add(client);


            ByteBuffer byteBuffer = ByteBuffer.allocateDirect(4096);

            for (SocketChannel channel : channels) {
                int read = channel.read(byteBuffer);
                if(read > 0){
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.limit()];
                    byteBuffer.get(bytes);
                    System.out.println(new String(bytes) + "client port" + port);
                    byteBuffer.clear();
                }
            }
        }
    }
}
