package com.xiaolee.netty.client.promise;

public interface CompleteListener {
    /**
     * complete success
     *
     * @param promise
     */
    default void success(Promise promise) {}

    /**
     * error occurred
     *
     * @param promise
     */
    default void error(Promise promise) {}
}
