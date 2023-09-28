package com.example.demo.net.chat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.InsecureTrustManagerFactory;

import javax.net.ssl.SSLException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public final class SecureChatClient {
    static final String HOST=System.getProperty("host","127.0.0.1");
    static final int PORT=Integer.parseInt(System.getProperty("port","8992"));

    public static void main(String[] args) throws SSLException {
        final SslContext sslCtx= SslContextBuilder.forClient().trustManager(InsecureTrustManagerFactory.INSTANCE).build();

        var group=new NioEventLoopGroup();

        try{
            var bootstrap=new Bootstrap();
            bootstrap.group(group).channel(NioSocketChannel.class).handler(new SecureChatClientInitializer(sslCtx));

            var channel=bootstrap.connect(HOST,PORT).sync().channel();

            ChannelFuture lastWriteFuture=null;

            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));

            for(;;){
                String line=in.readLine();
                if(line==null){
                    break;
                }

                lastWriteFuture=channel.writeAndFlush(line+"\r\n");
                if("bye".equals(line.toLowerCase())){
                    channel.closeFuture().sync();
                    break;
                }

                if(lastWriteFuture!=null){
                    lastWriteFuture.sync();
                }
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
    }
}
