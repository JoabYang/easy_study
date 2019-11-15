package com.joaby.easy.study.mybatis.v2.binding;

import com.joaby.easy.study.mybatis.v2.config.ConfigurationV2;
import com.joaby.easy.study.mybatis.v2.session.SqlSessionV2;

import java.lang.reflect.Proxy;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:44
 */
public class MapperProxyFactoryV2<T> {

    private Class<T> mapperInterface;
    private ConfigurationV2 configurationV2;

    public MapperProxyFactoryV2(Class<T> mapperInterface, ConfigurationV2 configurationV2) {
        this.mapperInterface = mapperInterface;
        this.configurationV2 = configurationV2;
    }

    public T newInstance(MapperProxyV2 mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

    public T newInstance(SqlSessionV2 sqlSessionV2) {
        MapperProxyV2 mapperProxyV2 = new MapperProxyV2(sqlSessionV2, configurationV2);
        return newInstance(mapperProxyV2);
    }
}
