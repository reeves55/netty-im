package com.xiaolee.netty.im.client.config;

/**
 * 从文件中解析配置属性
 */
public class FilePropertySource implements ClientPropertySource {

    /**
     * 服务器连接地址列表
     * @return
     */
    public String[] serverUrls() {
        return new String[0];
    }

    /**
     * 连接超时时间(ms)
     *
     * @return
     */
    public long connectTimeout() {
        return 0;
    }

    /**
     * 心跳间隙时间(ms)
     *
     * @return
     */
    public long heartbeatInterval() {
        return 0;
    }
}
