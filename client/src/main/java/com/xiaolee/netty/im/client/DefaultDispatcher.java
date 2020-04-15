package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.common.message.AppMsg;

import java.util.ArrayList;
import java.util.List;

public class DefaultDispatcher implements Dispatcher {
    private List<OnEventListener> listeners;

    DefaultDispatcher() {
        listeners = new ArrayList<>(4);
    }

    /**
     * 添加事件监听器
     */
    @Override
    public void addOnEventListener(OnEventListener listener) {
        synchronized (this) {
            listeners.add(listener);
        }
    }

    /**
     * 分发收到的消息
     *
     * @param msg
     */
    @Override
    public void dispatch(AppMsg msg) {
        for (OnEventListener listener : listeners) {
            listener.msgReceived(msg);
        }
    }
}
