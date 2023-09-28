package com.example.demo.net.netty;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class FirstClientHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("客户端发送消息");

        var byteBuf=getByteBuf(ctx);

        ctx.channel().writeAndFlush(byteBuf);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {

        var buffer=ctx.alloc().buffer();
        byte[] bytes="这是客户端发送的消息".getBytes(StandardCharsets.UTF_8);
        buffer.writeBytes(bytes);
        return buffer;

    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       var byteBuf=(ByteBuf)msg;

       System.out.println(byteBuf.toString(StandardCharsets.UTF_8));
    }

}
