package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.common.message.AppMsg;

public interface OnEventListener {
    /**
     * 接收到消息
     *
     * @param message
     */
    default void msgReceived(AppMsg message){}
}
