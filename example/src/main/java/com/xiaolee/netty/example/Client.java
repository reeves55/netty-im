package com.xiaolee.netty.example;

import com.xiaolee.netty.client.IMClient;
import com.xiaolee.netty.client.NettyIMClient;
import com.xiaolee.netty.client.OnEventListener;
import com.xiaolee.netty.client.config.StaticPropertySource;
import com.xiaolee.netty.client.promise.CompleteListener;
import com.xiaolee.netty.client.promise.Promise;
import com.xiaolee.netty.common.message.AppMsg;
import com.xiaolee.netty.common.message.AppMsgUtil;
import com.xiaolee.netty.common.message.PlainTextAppMsg;
import com.xiaolee.netty.common.protocol.Message;

public class Client {
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

            client.addOnEventListener(new OnEventListener() {
                @Override
                public void msgReceived(AppMsg message) {
                    if (message instanceof PlainTextAppMsg) {
                        System.out.println("接收到消息: " + message.getObject());
                    }
                }
            });

            client.sendTo("receiver", new PlainTextAppMsg("hello"))
                    .onComplete(new CompleteListener() {
                        @Override
                        public void error(Promise promise) {
                            System.out.println(promise.cause().getMessage());
                        }
                    });
            client.sendTo("receiver", new PlainTextAppMsg("byebye"));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
