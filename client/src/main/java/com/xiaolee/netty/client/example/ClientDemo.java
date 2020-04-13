package com.xiaolee.netty.client.example;

import com.xiaolee.netty.client.IMClient;
import com.xiaolee.netty.client.NettyIMClient;
import com.xiaolee.netty.client.core.config.StaticPropertySource;
import com.xiaolee.netty.client.core.promise.Promise;

public class ClientDemo {
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
