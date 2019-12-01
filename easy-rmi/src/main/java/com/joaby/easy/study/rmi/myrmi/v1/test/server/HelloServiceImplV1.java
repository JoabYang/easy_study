package com.joaby.easy.study.rmi.myrmi.v1.test.server;

import com.joaby.easy.study.rmi.myrmi.v1.test.jar.IHelloServiceV1;

public class HelloServiceImplV1 implements IHelloServiceV1 {
    @Override
    public String sayHello(String msg) {
        return "hello, " + msg;
    }
}
