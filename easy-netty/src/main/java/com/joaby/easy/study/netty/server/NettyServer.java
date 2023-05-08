package com.joaby.easy.study.netty.server;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

  public static void main(String[] args) throws InterruptedException {
    ServerBootstrap bootstrap = new ServerBootstrap();
    EventLoopGroup group = new NioEventLoopGroup();
    bootstrap.channel(NioServerSocketChannel.class)
        .group(group)
        .handler(new ChannelInitializer() {
          @Override
          protected void initChannel(Channel channel) throws Exception {

          }
        });
    ChannelFuture channelFuture = bootstrap.bind(8888).sync();
    channelFuture.channel().closeFuture().sync();
  }

}
