package com.xiaolee.netty.im.client.config;

import java.net.InetSocketAddress;

/**
 * 从对象中读取配置属性
 */
public class DefaultPropertySource implements PropertySource {
    private InetSocketAddress[] serverUrls;
    private int connectionTimeout;
    private long heartbeatInterval;

    public DefaultPropertySource() {
        // 初始化属性默认值
        serverUrls = null;
        connectionTimeout = 10 * 1000;
        heartbeatInterval = 5 * 1000;
    }

    public void addServer(String serverUrl) {

    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setHeartbeatInterval(long heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    /**
     * 服务器连接地址列表
     * @return
     */
    public InetSocketAddress[] serverUrls() {
        return serverUrls;
    }

    /**
     * 连接超时时间(ms)
     *
     * @return
     */
    public int connectTimeout() {
        return connectionTimeout;
    }

    /**
     * 心跳间隙时间(ms)
     *
     * @return
     */
    public long heartbeatInterval() {
        return heartbeatInterval;
    }

    /**
     * 使用线程数
     *
     * @return
     */
    @Override
    public int threads() {
        return 0;
    }


}
