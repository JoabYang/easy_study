package com.joaby.easy.study.rmi.demo.server;

import com.joaby.easy.study.rmi.demo.jar.IHelloService;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HelloServiceImpl extends UnicastRemoteObject implements IHelloService {
    public HelloServiceImpl() throws RemoteException {
//        super();
    }

    @Override
    public String sayHello(String msg) throws RemoteException {
        return "hello, " + msg;
    }
}
