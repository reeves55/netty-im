package com.xiaolee.netty.client.core.promise;

public interface Promise<T> {
    Promise<T> sync() throws InterruptedException;

    boolean isFailed();

    Promise<T> addListener(CompleteListener listener);
}
