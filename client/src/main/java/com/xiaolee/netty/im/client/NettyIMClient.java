package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.client.config.ClientPropertySource;
import com.xiaolee.netty.im.client.promise.ChannelFutureAdapter;
import com.xiaolee.netty.im.client.promise.Promise;
import com.xiaolee.netty.im.common.message.AppMsg;
import com.xiaolee.netty.im.common.protocol.Message;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;

public class NettyIMClient implements IMClient{
    private static final int DISCONNECTED = 0;
    private static final int CONNECTING = 1;
    private static final int CONNECTED = 2;
    // 客户端连接状态
    private volatile int status = DISCONNECTED;
    // 属性配置源，用于获取配置属性值
    private ClientPropertySource propertySource;
    // 消息分发器
    private Dispatcher dispatcher;
    // netty 网络连接
    private Channel connection;
    private Bootstrap bootstrap;


    public NettyIMClient(ClientPropertySource propertySource) {
        this.propertySource = propertySource;

        // init bootstrap
        bootstrap = new Bootstrap();
        bootstrap.group(NettyEventLoopFactory.eventLoopGroup(propertySource.threads()));
    }

    /**
     * 连接到IM服务器
     */
    public Promise connect() {
        if (status > DISCONNECTED) {
            // throw new ConnectException("client is connecting or has already connected to server");
        }

        String[] servers = propertySource.serverUrls();
        if (servers == null || servers.length == 0) {
            // throw new ConnectException("server urls are empty, please specify one available server url at least");
        }

        for (String url : servers) {
            // TODO: 连接到指定服务器，成功则理解返回，失败则尝试下一个地址，全部失败返回错误

        }

        return null;
    }

    /**
     * 登陆（用户名密码认证）
     * @return
     */
    public Promise login(String username, String password) {
        return null;
    }

    /**
     * 登陆（token认证）
     */
    public Promise login(String token) {
        return null;
    }

    /**
     * 发送消息
     */
    @Override
    public Promise sendTo(String receiver, AppMsg message) {
        Message msg = new Message();
        msg.setBody(message.getBytes());

        Message.Head head = new Message.Head();
        head.setTo(receiver);

        return new ChannelFutureAdapter(connection.writeAndFlush(msg));
    }

    /**
     * 添加事件监听器
     */
    @Override
    public void addOnEventListener(OnEventListener listener) {

    }

    /**
     * 关闭客户端，清理所有资源
     */
    @Override
    public void close() {

    }


}
