package com.xiaolee.netty.client;

import com.xiaolee.netty.common.message.AppMsg;
import com.xiaolee.netty.client.promise.Promise;

public interface IMClient {
    /**
     * 连接到IM服务器
     *
     * @return
     */
    Promise connect();

    /**
     * 登陆（用户名密码认证）
     *
     * @param username
     * @param password
     * @return
     */
    Promise login(String username, String password);

    /**
     * 登陆（token认证）
     *
     * @param token
     * @return
     */
    Promise login(String token);

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
}
