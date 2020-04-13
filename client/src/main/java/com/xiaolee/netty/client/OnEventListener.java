package com.xiaolee.netty.client;

import com.xiaolee.netty.common.protocol.Message;

public interface OnEventListener {
    /**
     * 接收到消息
     *
     * @param message
     */
    default void msgReceived(Message message){}
}
