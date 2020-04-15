package com.xiaolee.netty.im.client;

import com.xiaolee.netty.im.client.config.PropertySource;
import com.xiaolee.netty.im.client.exception.ConnectException;
import com.xiaolee.netty.im.client.promise.ChannelFutureAdapter;
import com.xiaolee.netty.im.client.promise.CompleteListener;
import com.xiaolee.netty.im.client.promise.Promise;
import com.xiaolee.netty.im.common.message.AppMsg;
import com.xiaolee.netty.im.common.message.AppMsgHandler;
import com.xiaolee.netty.im.common.protocol.Message;
import com.xiaolee.netty.im.common.protocol.MessageDecoder;
import com.xiaolee.netty.im.common.protocol.MessageEncoder;
import io.netty.bootstrap.Bootstrap;
import io.netty.buffer.PooledByteBufAllocator;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class NettyIMClient implements IMClient {
    private static final int DISCONNECTED = 0;
    private static final int CONNECTING = 1;
    private static final int CONNECTED = 2;
    // 客户端连接状态
    private volatile int status = DISCONNECTED;
    // 属性配置源，用于获取配置属性值
    private PropertySource propertySource;
    // 消息分发器
    private Dispatcher dispatcher;
    // netty 网络连接
    private Channel connection;
    private Bootstrap bootstrap;
    // server address
    private InetSocketAddress server;

    public NettyIMClient(PropertySource propertySource) {
        this.propertySource = propertySource;

        // init bootstrap
        bootstrap = new Bootstrap();
        bootstrap.group(NettyEventLoopFactory.eventLoopGroup(propertySource.threads()))
                .option(ChannelOption.SO_KEEPALIVE, true)
                .option(ChannelOption.ALLOCATOR, PooledByteBufAllocator.DEFAULT)
                .option(ChannelOption.TCP_NODELAY, true)
                .option(ChannelOption.CONNECT_TIMEOUT_MILLIS, Math.max(3000, propertySource.connectTimeout()))
                .channel(NioSocketChannel.class)
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline()
                                .addLast(new MessageDecoder())
                                .addLast(new MessageEncoder())
                                .addLast(new AppMsgHandler());
                    }
                });
    }

    /**
     * 连接到IM服务器
     */
    public Promise connect() throws ConnectException{
        if (status > DISCONNECTED) {
            throw new ConnectException("client is connecting or has already connected to server");
        }

        if (server == null) {
            InetSocketAddress[] servers = propertySource.serverUrls();
            if (servers == null || servers.length == 0) {
                throw new ConnectException("server urls are empty, please specify one available server url at least");
            }

            server = selectServer(servers, null);
            if (server == null) {
                throw new ConnectException("网络错误，无法连接到服务器，请检查");
            }
        }

        ChannelFuture future = bootstrap.connect(server);
        return new ChannelFutureAdapter(future).onComplete(new CompleteListener() {
            @Override
            public void success(Promise promise) {
                connection = future.channel();
                updateStatus(CONNECTED);
            }

            @Override
            public void error(Promise promise) {
                // 连接出错
            }
        });
    }

    private void updateStatus(int status) {
        this.status = status;
    }

    private InetSocketAddress selectServer(InetSocketAddress[] servers, InetSocketAddress[] except) {
        Set<InetSocketAddress> exceptSet = new HashSet<InetSocketAddress>();
        InetSocketAddress selectedServer = null;

        if (except != null && except.length > 0) {
            exceptSet.addAll(Arrays.asList(except));
        }

        for (InetSocketAddress address : servers) {
            if (exceptSet.contains(address)) {
                continue;
            }

            try {
                if (address.getAddress().isReachable(3000)) {
                    selectedServer = address;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return selectedServer;
    }

    /**
     * 登陆（用户名密码认证）
     *
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
