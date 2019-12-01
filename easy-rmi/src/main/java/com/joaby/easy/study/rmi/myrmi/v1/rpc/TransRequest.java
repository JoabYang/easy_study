package com.joaby.easy.study.rmi.myrmi.v1.rpc;

import java.io.Serializable;

public class TransRequest implements Serializable {

    private static final long serialVersionUID = 2631469788581354601L;
    private String methodName;
    private Object[] parameters;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }
}
