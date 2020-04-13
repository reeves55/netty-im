package com.xiaolee.netty.client.example;

import com.xiaolee.netty.client.IMClient;
import com.xiaolee.netty.client.NettyIMClient;
import com.xiaolee.netty.client.config.StaticPropertySource;
import com.xiaolee.netty.client.promise.CompleteListener;
import com.xiaolee.netty.client.promise.Promise;
import com.xiaolee.netty.common.message.PlainTextOutMessage;

public class ClientDemo {
    public static void main(String[] args) {
        StaticPropertySource ps = new StaticPropertySource();
        ps.addServer("http://localhost:8777");
        ps.setConnectionTimeout(10 * 1000);

        IMClient client = new NettyIMClient(ps);
        try {
            Promise connPromise = client.connect().sync();
            if (connPromise.isFailed()) {
                // handle connection failed
                System.out.println("连接出错: " + connPromise.cause().getMessage());
                return;
            }

            client.sendTo("receiver", new PlainTextOutMessage("hello"))
                    .addListener(new CompleteListener() {
                        @Override
                        public void onError(Promise promise) {
                            System.out.println(promise.cause().getMessage());
                        }
                    });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
