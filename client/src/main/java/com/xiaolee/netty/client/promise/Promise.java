package com.xiaolee.netty.client.promise;

public interface Promise {
    Promise sync() throws InterruptedException;

    boolean isFailed();
}
