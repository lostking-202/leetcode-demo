package com.example.demo.net.chat;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import io.netty.util.concurrent.GlobalEventExecutor;

import java.net.InetAddress;

public class SecureChatServerHandler extends SimpleChannelInboundHandler<String> {

    static final ChannelGroup channels=new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        ctx.pipeline().get(SslHandler.class).handshakeFuture().addListener((GenericFutureListener<Future<Channel>>) future -> {
            ctx.writeAndFlush("Welcome to "+ InetAddress.getLocalHost().getHostName()+" secure char service! \n");

            ctx.writeAndFlush("Your session is protected by "+ ctx.pipeline().get(SslHandler.class).engine().getSession().getCipherSuite()+" cipher suite \n");

            channels.add(ctx.channel());
        });
    }

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, String s) throws Exception {
        for(Channel c:channels){
            if(c!=channelHandlerContext.channel()){
                c.writeAndFlush("["+ channelHandlerContext.channel().remoteAddress()+"]"+s+"\n");
            }else{
                c.writeAndFlush("[you] "+ s+"\n");
            }
        }
        if("bye".equalsIgnoreCase(s)){
            channelHandlerContext.close();
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,Throwable cause){
        cause.printStackTrace();
        ctx.close();
    }
}
