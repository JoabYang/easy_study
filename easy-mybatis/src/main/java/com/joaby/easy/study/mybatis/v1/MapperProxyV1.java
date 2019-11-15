package com.joaby.easy.study.mybatis.v1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MapperProxyV1 implements InvocationHandler {
    private SqlSessionV1 sqlSession;

    public MapperProxyV1(SqlSessionV1 sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (ConfigurationV1.TestMapperXml.NAMESPACE.equals(method.getDeclaringClass().getName())) {
            String sql = ConfigurationV1.TestMapperXml.methodMapper.get(method.getName());
            if (sql != null) {
                return sqlSession.selectOne(sql, String.valueOf(args[0]));
            }
        }
        return method.invoke(this, args);
    }
}
