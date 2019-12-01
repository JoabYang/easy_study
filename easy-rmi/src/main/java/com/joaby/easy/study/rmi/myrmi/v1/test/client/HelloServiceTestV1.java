package com.joaby.easy.study.rmi.myrmi.v1.test.client;

import com.joaby.easy.study.rmi.myrmi.v1.rpc.RpcClientProxy;
import com.joaby.easy.study.rmi.myrmi.v1.test.jar.IHelloServiceV1;

public class HelloServiceTestV1 {
    public static void main(String[] args) {
        IHelloServiceV1 helloService = RpcClientProxy.newServiceProxy(IHelloServiceV1.class, "localhost", 8888);
        System.out.println(helloService.sayHello("joaby"));
    }
}
