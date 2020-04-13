package com.xiaolee.netty.client.promise;

public interface CompleteListener {
    /**
     * complete success
     *
     * @param promise
     */
    default void onSuccess(Promise promise) {}

    /**
     * error occurred
     *
     * @param promise
     */
    default void onError(Promise promise) {}
}
