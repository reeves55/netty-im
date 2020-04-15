package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.client.exception.ConnectException;
import com.xiaolee.netty.im.common.message.AppMsg;
import com.xiaolee.netty.im.client.promise.Promise;

public interface IMClient {
    /**
     * 连接到IM服务器
     *
     * @return
     */
    Promise connect() throws ConnectException;

    /**
     * 发送消息
     */
    Promise sendTo(String receiver, AppMsg message);

    /**
     * 添加事件监听器
     *
     * @param listener
     */
    void addOnEventListener(OnEventListener listener);

    /**
     * 关闭客户端，清理所有资源
     */
    void close();
}
