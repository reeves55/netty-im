package com.xiaolee.netty.im.client;

public interface Dispatcher {
    /**
     * 添加事件监听器
     *
     * @param listener
     */
    void addOnEventListener(OnEventListener listener);
}
