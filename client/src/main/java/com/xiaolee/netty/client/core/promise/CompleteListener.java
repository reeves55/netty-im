package com.xiaolee.netty.client.core.promise;

public interface CompleteListener<T> {
    public void onComplete(Promise<T> promise);
}
