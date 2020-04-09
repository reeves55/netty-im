package com.xiaolee.netty.client.config;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 从对象中读取配置属性
 */
public class StaticPropertySource implements PropertySource {
    private String[] serverUrls;

    public StaticPropertySource() {

    }

    public String[] serverUrls() {
        return serverUrls;
    }


}
