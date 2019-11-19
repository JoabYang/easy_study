package com.joaby.easy.study.mybatis.v2.binding;

import com.joaby.easy.study.mybatis.v2.config.ConfigurationV2;
import com.joaby.easy.study.mybatis.v2.session.SqlSessionV2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:46
 */
public class MapperProxyV2 implements InvocationHandler {

    private SqlSessionV2 sqlSessionV2;
    private ConfigurationV2 configurationV2;

    public MapperProxyV2(SqlSessionV2 sqlSessionV2, ConfigurationV2 configurationV2) {
        this.sqlSessionV2 = sqlSessionV2;
        this.configurationV2 = configurationV2;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Map<String, ConfigurationV2.MapperEntity> mapperEntityMap = configurationV2.getMapperEntityMap();
        String key = method.getDeclaringClass().getName() + "." + method.getName();
        if (mapperEntityMap.containsKey(key)) {
            ConfigurationV2.MapperEntity mapperEntity = mapperEntityMap.get(key);
            return sqlSessionV2.selectOne(mapperEntity.SQL, args[0], mapperEntity.RESULTTYPE, mapperEntity.FIELDNAMES);
        }
        return method.invoke(this, args);
    }
}
