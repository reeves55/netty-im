package com.xiaolee.netty.client.core.promise;

public class DefaultPromise implements Promise{

    public Promise sync() throws InterruptedException {
        return null;
    }

    public boolean isFailed() {
        return false;
    }
}
