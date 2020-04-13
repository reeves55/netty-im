package com.xiaolee.netty.client;

import io.netty.util.concurrent.Promise;

public interface IMClient {
    /**
     * 连接到IM服务器
     * @return
     */
    Promise connect();


}
