package com.joaby.easy.study.mybatis.v2.binding;

import com.joaby.easy.study.mybatis.v2.config.ConfigurationV2;
import com.joaby.easy.study.mybatis.v2.session.SqlSessionV2;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:43
 */
public class MapperRegistryV2 {

    private ConfigurationV2 configurationV2;

    public MapperRegistryV2(ConfigurationV2 configurationV2) {
        this.configurationV2 = configurationV2;
    }

    public <T> T getMapper(Class<T> type, SqlSessionV2 sqlSessionV2) {
        MapperProxyFactoryV2<T> mapperProxyFactoryV2 = new MapperProxyFactoryV2<>(type, configurationV2);
        return mapperProxyFactoryV2.newInstance(sqlSessionV2);
    }
}
