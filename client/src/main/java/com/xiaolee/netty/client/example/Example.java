package com.xiaolee.netty.client.example;

import com.xiaolee.netty.client.IMClient;
import com.xiaolee.netty.client.NettyIMClient;
import com.xiaolee.netty.client.config.StaticPropertySource;
import com.xiaolee.netty.client.promise.Promise;

public class Example {
    public static void main(String[] args) {
        StaticPropertySource ps = new StaticPropertySource();
        ps.addServer("http://localhost:8777");
        ps.setConnectionTimeout(10 * 1000);

        IMClient client = new NettyIMClient(ps);
        try {
            Promise promise = client.connect().sync();
            if (promise.isFailed()) {
                // handle connection failed
            }



        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
