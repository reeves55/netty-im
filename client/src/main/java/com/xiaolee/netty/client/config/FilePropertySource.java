package com.xiaolee.netty.client.config;

/**
 * 从文件中解析配置属性
 */
public class FilePropertySource implements PropertySource{

    public String[] serverUrls() {
        return new String[0];
    }
}
