package com.xiaolee.netty.im.client.config;

/**
 * 从对象中读取配置属性
 */
public class StaticPropertySource implements ClientPropertySource {
    private String[] serverUrls;
    private long connectionTimeout;
    private long heartbeatInterval;

    public StaticPropertySource() {
        // 初始化属性默认值
        serverUrls = null;
        connectionTimeout = 10 * 1000;
        heartbeatInterval = 5 * 1000;
    }

    public void addServer(String serverUrl) {

    }

    public void setConnectionTimeout(long connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public void setHeartbeatInterval(long heartbeatInterval) {
        this.heartbeatInterval = heartbeatInterval;
    }

    /**
     * 服务器连接地址列表
     * @return
     */
    public String[] serverUrls() {
        return serverUrls;
    }

    /**
     * 连接超时时间(ms)
     *
     * @return
     */
    public long connectTimeout() {
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


}
