package com.joaby.easy.study.rmi.myrmi.v1.rpc;

import java.lang.reflect.Proxy;

public class RpcClientProxy {

    public static <T> T newServiceProxy(final Class<T> interfaceClass, final String host, final int port) {
        return (T) Proxy.newProxyInstance(interfaceClass.getClassLoader(), new Class[]{interfaceClass}, new RemoteServiceInvocationHandler(host, port));
    }
}
