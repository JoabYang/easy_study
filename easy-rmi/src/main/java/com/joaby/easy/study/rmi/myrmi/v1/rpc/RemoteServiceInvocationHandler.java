package com.joaby.easy.study.rmi.myrmi.v1.rpc;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.net.Socket;

public class RemoteServiceInvocationHandler implements InvocationHandler {

    private final String host;
    private final int port;

    public RemoteServiceInvocationHandler(final String host, final int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 建立连接
        Socket socket = null;
        try {
            socket = new Socket(this.host, this.port);

            // 组装需要调用的方法名和参数
            TransRequest request = new TransRequest();
            request.setMethodName(method.getName());
            request.setParameters(args);

            // 将需要调用的方法及参数传给服务端
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(request);
            objectOutputStream.flush();

            // 获得服务端的执行结果
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Object result = objectInputStream.readObject();

            // 关闭流
            objectInputStream.close();
            objectOutputStream.close();
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
        return null;
    }
}
