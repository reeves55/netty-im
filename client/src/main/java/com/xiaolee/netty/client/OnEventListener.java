package com.xiaolee.netty.client;

import com.xiaolee.netty.common.message.AppMsg;

public interface OnEventListener {
    /**
     * 接收到消息
     *
     * @param message
     */
    default void msgReceived(AppMsg message){}
}
