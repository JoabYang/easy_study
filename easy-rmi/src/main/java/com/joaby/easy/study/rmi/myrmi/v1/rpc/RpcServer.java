package com.joaby.easy.study.rmi.myrmi.v1.rpc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;

public class RpcServer {

    public static void publish(final Object service, final int port) {
        ServerSocket serverSocket = null;
        Socket socket = null;
        try {
            // 建立连接
            serverSocket = new ServerSocket(port);

            while (true) {
                // 接收请求
                socket = serverSocket.accept();
                // 获取请求方法及参数
                ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
                TransRequest request = (TransRequest) objectInputStream.readObject();

                // 调用本地方法获取结果
                Object result = execute(service, request);

                // 将执行结果返给调用方
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
                objectOutputStream.writeObject(result);
                objectOutputStream.flush();

                // 关闭流
                objectOutputStream.close();
                objectInputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Object execute(Object service, TransRequest request) throws Exception {
        Class<?> serviceClass = service.getClass();
        // 获取参数
        Object[] parameters = request.getParameters();
        // 没有参数则直接调用方法
        if (parameters == null) {
            Method method = serviceClass.getMethod(request.getMethodName());
            return method.invoke(service);
        }
        // 获取所有参数类型
        Class<?>[] types = new Class[parameters.length];
        for (int i = 0; i < parameters.length; i++) {
            types[i] = parameters[i].getClass();
        }
        // 获取对应方法
        Method method = serviceClass.getMethod(request.getMethodName(), types);
        // 调用并返回
        return method.invoke(service, parameters);
    }
}
