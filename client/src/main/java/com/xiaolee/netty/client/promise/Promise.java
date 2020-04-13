package com.xiaolee.netty.client.promise;

public interface Promise {
    /**
     * 同步等待
     *
     * @return
     * @throws InterruptedException
     */
    Promise sync() throws InterruptedException;

    /**
     * 是否执行失败
     *
     * @return
     */
    boolean isFailed();

    /**
     * 添加事件监听器
     *
     * @param listener
     * @return
     */
    Promise addListener(CompleteListener listener);

    /**
     * 获取执行异常信息
     *
     * @return
     */
    Exception cause();
}
