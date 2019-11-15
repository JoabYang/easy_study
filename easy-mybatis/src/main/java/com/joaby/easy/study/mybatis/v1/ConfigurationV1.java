package com.joaby.easy.study.mybatis.v1;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:53
 */
public class ConfigurationV1 {

    public <T> T getMapper(Class<T> type, SqlSessionV1 sqlSession) {
        return (T) Proxy.newProxyInstance(type.getClassLoader(),
                new Class[]{type},
                new MapperProxyV1(sqlSession));
    }

    static class TestMapperXml {
        public static final String NAMESPACE = "com.joaby.easy.study.mybatis.mapper.TestMapper";

        public static final Map<String, String> methodMapper = new HashMap<>();

        static {
            methodMapper.put("selectByPrimaryKey", "select * from test where id = ?");
        }
    }
}
