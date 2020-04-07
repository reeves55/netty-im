package com.xiaolee.netty.client;

import com.xiaolee.netty.client.promise.Promise;

public class NettyClient implements IMClient{
    private static final int DISCONNECTED = 0;
    private static final int CONNECTING = 1;
    private static final int CONNECTED = 2;

    // 客户端连接状态
    private volatile int connectStatus = DISCONNECTED;
    // 服务器
    private String[] servers;

    /**
     * 连接到IM服务器
     */
    public Promise connect(String[] servers) {
        if (connectStatus > DISCONNECTED) {

        }
        return null;
    }
}
