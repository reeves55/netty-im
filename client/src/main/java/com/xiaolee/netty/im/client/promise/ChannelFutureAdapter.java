package com.xiaolee.netty.im.client.promise;

import io.netty.channel.ChannelFuture;

public class ChannelFutureAdapter extends DefaultPromise {
    /**
     * netty channel future
     */
    private ChannelFuture future;

    public ChannelFutureAdapter(ChannelFuture future) {
        this.future = future;
    }


}
