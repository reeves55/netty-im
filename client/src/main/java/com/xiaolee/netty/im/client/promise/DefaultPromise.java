package com.xiaolee.netty.im.client.promise;

public class DefaultPromise implements Promise{
    private Exception cause;
    private volatile boolean isFailed;

    public Promise sync() throws InterruptedException {
        return null;
    }

    public boolean isFailed() {
        return false;
    }

    @Override
    public Promise onComplete(CompleteListener listener) {
        return null;
    }

    /**
     * 获取执行异常信息
     */
    @Override
    public Exception cause() {
        return cause;
    }

    public void fail(Exception e) {
        cause = e;
        isFailed = true;
    }
}
