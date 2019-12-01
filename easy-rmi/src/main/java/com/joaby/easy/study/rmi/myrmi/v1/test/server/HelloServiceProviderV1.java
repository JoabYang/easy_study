package com.joaby.easy.study.rmi.myrmi.v1.test.server;

import com.joaby.easy.study.rmi.myrmi.v1.rpc.RpcServer;
import com.joaby.easy.study.rmi.myrmi.v1.test.jar.IHelloServiceV1;

public class HelloServiceProviderV1 {

    public static void main(String[] args) {
        IHelloServiceV1 helloService = new HelloServiceImplV1();
        RpcServer.publish(helloService, 8888);
    }
}
