package com.xiaolee.netty.client;

import com.xiaolee.netty.client.core.config.ClientPropertySource;
import io.netty.util.concurrent.Promise;

public class NettyIMClient implements IMClient{
    private static final int DISCONNECTED = 0;
    private static final int CONNECTING = 1;
    private static final int CONNECTED = 2;
    // 客户端连接状态
    private volatile int connectStatus = DISCONNECTED;
    // 属性配置源，用于获取配置属性值
    private ClientPropertySource propertySource;

    /**
     * 构造方法
     */
    public NettyIMClient(ClientPropertySource propertySource) {
        this.propertySource = propertySource;
    }

    /**
     * 连接到IM服务器
     */
    public Promise connect() {

        if (connectStatus > DISCONNECTED) {
            // throw new ConnectException("client is connecting or has already connected to server");
        }

        String[] servers = propertySource.serverUrls();
        if (servers == null || servers.length == 0) {
            // throw new ConnectException("server urls are empty, please specify one available server url at least");
        }

        for (String url : servers) {
            // TODO: 连接到指定服务器，成功则理解返回，失败则尝试下一个地址，全部失败返回错误
        }

        return null;
    }
}
