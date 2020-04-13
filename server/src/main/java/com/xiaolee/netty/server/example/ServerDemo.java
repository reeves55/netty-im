package com.xiaolee.netty.server.example;

import com.xiaolee.netty.server.NettyIMServer;
import com.xiaolee.netty.server.config.ServerPropertySource;
import com.xiaolee.netty.server.config.StaticPropertySource;

public class ServerDemo {
    public static void main(String[] args) {
        ServerPropertySource ps = new StaticPropertySource();
        NettyIMServer server = new NettyIMServer(ps);


    }
}
