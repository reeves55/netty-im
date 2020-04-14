package com.xiaolee.netty.im.server.example;

import com.xiaolee.netty.im.server.NettyIMServer;
import com.xiaolee.netty.im.server.config.ServerPropertySource;
import com.xiaolee.netty.im.server.config.StaticPropertySource;

public class ServerDemo {
    public static void main(String[] args) {
        ServerPropertySource ps = new StaticPropertySource();
        NettyIMServer server = new NettyIMServer(ps);


    }
}
