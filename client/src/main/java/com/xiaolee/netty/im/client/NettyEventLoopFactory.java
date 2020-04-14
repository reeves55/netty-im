package com.xiaolee.netty.im.client;

import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.util.concurrent.DefaultThreadFactory;

import java.util.concurrent.ThreadFactory;

public class NettyEventLoopFactory {
    private static final int DEFAULT_THREADS = Runtime.getRuntime().availableProcessors() + 1;
    private static final int MAX_THREADS = 32;
    private static final String DEFAULT_THREAD_POOL_NAME = "";

    /**
     * NioEventLoopGroup factory method
     *
     * @return
     */
    public static NioEventLoopGroup eventLoopGroup(int threads, String threadPoolName) {
        threads = (threads < 1) ? DEFAULT_THREADS : Math.min(threads, MAX_THREADS);

        if (threadPoolName == null) {
            threadPoolName = DEFAULT_THREAD_POOL_NAME;
        }

        ThreadFactory threadFactory = new DefaultThreadFactory(threadPoolName, true);
        return new NioEventLoopGroup(threads, threadFactory);
    }

    public static NioEventLoopGroup eventLoopGroup(int threads) {
        threads = (threads < 1) ? DEFAULT_THREADS : Math.min(threads, MAX_THREADS);
        return eventLoopGroup(threads, DEFAULT_THREAD_POOL_NAME);
    }

    public static NioEventLoopGroup eventLoopGroup() {
        return eventLoopGroup(DEFAULT_THREADS, DEFAULT_THREAD_POOL_NAME);
    }
}
