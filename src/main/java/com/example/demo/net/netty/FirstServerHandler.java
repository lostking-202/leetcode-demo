package com.example.demo.net.netty;


import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.nio.charset.StandardCharsets;

public class FirstServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
       var byteBuf=(ByteBuf)msg;

       System.out.println("服务端读到数据->"+byteBuf.toString(StandardCharsets.UTF_8));

       var out=getByteBuf(ctx);
       ctx.channel().writeAndFlush(out);
    }

    private ByteBuf getByteBuf(ChannelHandlerContext ctx) {
        var bytes="我是服务器，我收到你的消息了".getBytes(StandardCharsets.UTF_8);
        var buffer=ctx.alloc().buffer();
        buffer.writeBytes(bytes);
        return buffer;
    }
}
