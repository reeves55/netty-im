package com.xiaolee.netty.client.example;

import com.xiaolee.netty.client.IMClient;
import com.xiaolee.netty.client.NettyIMClient;
import com.xiaolee.netty.client.core.config.StaticPropertySource;
import com.xiaolee.netty.client.core.promise.CompleteListener;
import com.xiaolee.netty.client.core.promise.Promise;
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
            }

            client.sendTo("receiver", new PlainTextOutMessage("hello"))
                    .addListener(new CompleteListener<String>() {
                        @Override
                        public void onComplete(Promise<String> promise) {
                            System.out.println("消息发送完毕");
                        }
                    });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
