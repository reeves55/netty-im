package com.xiaolee.netty.client;

import com.xiaolee.netty.client.exception.ConnectException;
import com.xiaolee.netty.client.promise.Promise;

public interface IMClient {
    /**
     * 连接到IM服务器
     * @return
     */
    Promise connect() throws ConnectException;


}
