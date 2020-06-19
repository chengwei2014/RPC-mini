package com.user.rpc.v1;

import java.lang.reflect.Proxy;

/**
 * RPC客户端代理
 * 2020-06-18
 */
public class RPCProxyClient {
    public <T> T clientProxy(Class<T> interfaceCls,String host,int port){
        return (T) Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class[]{interfaceCls}, new RemoteInvocationHandler(host, port));
    }
}
