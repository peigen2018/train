package com.pg.netty.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

public class Demo {
    public static void main(String[] args) throws IOException {

        ServerSocketChannel serverSocket = ServerSocketChannel.open();
        serverSocket.bind(new InetSocketAddress(9091));
        serverSocket.configureBlocking(false);

        Selector selector = Selector.open();


        while (selector.select() > 1){

        }
    }
}
