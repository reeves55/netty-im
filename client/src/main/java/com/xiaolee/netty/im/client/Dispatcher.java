package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.common.message.AppMsg;

public interface Dispatcher {
    /**
     * 添加事件监听器
     *
     * @param listener
     */
    void addOnEventListener(OnEventListener listener);

    /**
     * 分发收到的消息
     *
     * @param msg
     */
    void dispatch(AppMsg msg);
}
