package com.xiaolee.netty.im.server;

import com.xiaolee.netty.im.server.config.ServerPropertySource;

public class NettyIMServer implements IMServer{
    private ServerPropertySource propertySource;

    public NettyIMServer(ServerPropertySource propertySource) {
        this.propertySource = propertySource;
    }


}
