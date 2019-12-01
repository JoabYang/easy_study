package com.joaby.easy.study.rmi.demo.client;

import com.joaby.easy.study.rmi.demo.jar.IHelloService;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class HelloServiceTest {
    public static void main(String[] args) throws RemoteException, NotBoundException, MalformedURLException {
        IHelloService helloService = (IHelloService) Naming.lookup("rmi://127.0.0.1/hello");
        System.out.println(helloService.sayHello("joaby"));
    }
}
