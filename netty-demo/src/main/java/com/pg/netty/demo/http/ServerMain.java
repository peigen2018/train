package com.pg.netty.demo.http;

import com.pg.netty.demo.http.handler.MsgHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;

public class ServerMain {
    public static void main(String[] args)  {


        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap bootstrap = new ServerBootstrap();

        bootstrap.group(bossGroup, workerGroup);
        bootstrap.channel(NioServerSocketChannel.class);
        bootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel ch) throws Exception {
                ch.pipeline().addLast(new HttpResponseEncoder(),
                        new HttpRequestDecoder());
                ch.pipeline().addLast(new MsgHandler());
            }
        });


        ChannelFuture sync = null;
        try {
            sync = bootstrap.bind(9011).sync();
            if(sync.isSuccess()){
                System.out.println("success");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
