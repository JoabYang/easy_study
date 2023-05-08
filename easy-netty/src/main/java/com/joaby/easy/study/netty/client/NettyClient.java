package com.joaby.easy.study.netty.client;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.net.InetSocketAddress;

public class NettyClient {

  public static void main(String[] args) throws InterruptedException {
    Bootstrap bootstrap = new Bootstrap();
    EventLoopGroup group = new NioEventLoopGroup();
    ChannelFuture channelFuture = bootstrap.channel(NioSocketChannel.class)
        .group(group)
        .handler(new ChannelInitializer() {
          @Override
          protected void initChannel(Channel channel) throws Exception {

          }
        })
        .connect(new InetSocketAddress("127.0.0.1", 8888))
        .sync();
    channelFuture.channel().closeFuture().sync();
  }

}
