package com.xiaolee.netty.client.core.config;

public interface ClientPropertySource {
    /**
     * 服务器连接地址列表
     * @return
     */
    String[] serverUrls();

    /**
     * 连接超时时间(ms)
     * @return
     */
    long connectTimeout();

    /**
     * 心跳间隙时间(ms)
     * @return
     */
    long heartbeatInterval();
}
