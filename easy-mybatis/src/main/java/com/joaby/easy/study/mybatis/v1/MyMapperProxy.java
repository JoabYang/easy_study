package com.joaby.easy.study.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyMapperProxy implements InvocationHandler {
    private MySqlSession sqlSession;

    public MyMapperProxy(MySqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (MyConfiguration.TestMapperXml.NAMESPACE.equals(method.getDeclaringClass().getName())) {
            String sql = MyConfiguration.TestMapperXml.methodMapper.get(method.getName());
            if (sql != null) {
                return sqlSession.selectOne(sql, String.valueOf(args[0]));
            }
        }
        return method.invoke(this, args);
    }
}
