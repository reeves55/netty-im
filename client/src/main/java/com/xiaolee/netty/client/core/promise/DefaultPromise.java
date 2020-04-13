package com.xiaolee.netty.client.core.promise;

public class DefaultPromise<T> implements Promise<T>{

    public Promise<T> sync() throws InterruptedException {
        return null;
    }

    public boolean isFailed() {
        return false;
    }

    @Override
    public Promise<T> addListener(CompleteListener listener) {
        return null;
    }
}
