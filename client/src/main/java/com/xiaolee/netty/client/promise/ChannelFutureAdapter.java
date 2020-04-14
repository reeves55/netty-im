package com.xiaolee.netty.client.promise;

import io.netty.channel.ChannelFuture;

public class ChannelFutureAdapter extends DefaultPromise implements Promise{
    /**
     * netty channel future
     */
    private ChannelFuture future;

    public ChannelFutureAdapter(ChannelFuture future) {
        this.future = future;
    }


}
