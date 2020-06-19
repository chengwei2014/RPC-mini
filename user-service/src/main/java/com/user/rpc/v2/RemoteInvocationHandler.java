package com.user.rpc.v2;

import com.order.rpc.RpcRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 客户端远程调用代理处理
 * 2020-06-18
 */
@Component
public class RemoteInvocationHandler implements InvocationHandler {
    @Value("${gp.host}")
    private String host;
    @Value("${gp.port}")
    private int port;

    public RemoteInvocationHandler() {
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //建立远程连接
        RPCNetTransport rpcNetTransport = new RPCNetTransport(this.host, this.port);
//        RPCNetTransport rpcNetTransport = new RPCNetTransport("localhost", 8888);
        //封装请求内容
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setArgs(args);
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setTypes(method.getParameterTypes());
        return rpcNetTransport.send(rpcRequest);
    }
}
