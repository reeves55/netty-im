package com.xiaolee.netty.im.client.promise;

import java.util.concurrent.Future;

public class FutureAdapter extends DefaultPromise{
    Future future;

    public FutureAdapter() {
        // do nothing
    }

    public FutureAdapter(Future future) {
        this.future = future;
    }

    public FutureAdapter future(Future future) {
        this.future = future;
        return this;
    }


}
