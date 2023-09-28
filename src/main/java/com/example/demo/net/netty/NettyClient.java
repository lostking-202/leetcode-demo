package com.example.demo.net.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyClient {

    public static void main(String[] args) {
        var workerGroup=new NioEventLoopGroup();

        var bootstrap=new Bootstrap();

        bootstrap.group(workerGroup).channel(NioSocketChannel.class).handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new FirstClientHandler());
            }
        });

        bootstrap.connect("127.0.0.1",8000).addListener(future -> {
            if(future.isSuccess()){
                System.out.println("连接成功");
            }else{
                System.out.println("连接失败");
            }
        });
    }
}
