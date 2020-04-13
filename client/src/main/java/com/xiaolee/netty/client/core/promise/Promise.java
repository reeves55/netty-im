package com.xiaolee.netty.client.core.promise;

public interface Promise {
    Promise sync() throws InterruptedException;

    boolean isFailed();
}
