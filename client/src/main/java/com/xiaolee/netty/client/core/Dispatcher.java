package com.xiaolee.netty.client.core;

public interface Dispatcher {
    /**
     * 添加事件监听器
     *
     * @param listener
     */
    void addOnEventListener(OnEventListener listener);
}
