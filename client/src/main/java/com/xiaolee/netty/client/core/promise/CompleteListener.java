package com.xiaolee.netty.client.core.promise;

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
