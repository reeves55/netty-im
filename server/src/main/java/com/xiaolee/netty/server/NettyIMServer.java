package com.xiaolee.netty.server;

import com.xiaolee.netty.server.config.ServerPropertySource;

public class NettyIMServer implements IMServer{
    private ServerPropertySource propertySource;

    public NettyIMServer(ServerPropertySource propertySource) {
        this.propertySource = propertySource;
    }


}
