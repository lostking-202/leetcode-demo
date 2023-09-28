package com.example.demo.net.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class NettyServer {
    public static void main(String[] args) {
        // 两个NioEventLoopGroup对象，可以看作两个线程组。bossGroup的作用是监听客户端请求。workerGroup的作用是处理每条连接的数据读写。
        var bossGroup=new NioEventLoopGroup();
        var workGroup=new NioEventLoopGroup();

        //ServerBootstrap是一个引导类，其对象的作用是引导服务器的启动工作。
        var serverBootstrap=new ServerBootstrap();

        serverBootstrap.group(bossGroup,workGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<NioSocketChannel>() {
            @Override
            protected void initChannel(NioSocketChannel nioSocketChannel) throws Exception {
                nioSocketChannel.pipeline().addLast(new FirstServerHandler());
            }
        });

        serverBootstrap.bind(8000);
    }
}
