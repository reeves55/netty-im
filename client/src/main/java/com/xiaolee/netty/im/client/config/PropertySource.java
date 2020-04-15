package com.xiaolee.netty.im.client.config;

import java.net.InetSocketAddress;

public interface PropertySource {
    /**
     * 服务器连接地址列表
     * @return
     */
    InetSocketAddress[] serverUrls();

    /**
     * 连接超时时间(ms)
     * @return
     */
    int connectTimeout();

    /**
     * 心跳间隙时间(ms)
     * @return
     */
    long heartbeatInterval();

    /**
     * 使用线程数
     * @return
     */
    int threads();
}
