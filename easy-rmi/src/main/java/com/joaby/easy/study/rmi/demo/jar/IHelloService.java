package com.joaby.easy.study.rmi.demo.jar;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IHelloService extends Remote {
    String sayHello(String msg) throws RemoteException;
}
