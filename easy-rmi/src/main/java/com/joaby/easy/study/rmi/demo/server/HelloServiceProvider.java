package com.joaby.easy.study.rmi.demo.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class HelloServiceProvider {
    public static void main(String[] args) throws Exception {
        LocateRegistry.createRegistry(1099);
        Naming.rebind("rmi://127.0.0.1/hello", new HelloServiceImpl());
    }
}
