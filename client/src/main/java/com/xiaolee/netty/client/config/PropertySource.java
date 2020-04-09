package com.xiaolee.netty.client.config;

public interface PropertySource {
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
