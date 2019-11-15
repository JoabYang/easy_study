package com.joaby.easy.study.mybatis.v2.config;

import com.joaby.easy.study.mybatis.entity.Test;
import com.joaby.easy.study.mybatis.v2.binding.MapperRegistryV2;
import com.joaby.easy.study.mybatis.v2.session.SqlSessionV2;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:53
 */
public class ConfigurationV2 {

    private MapperRegistryV2 mapperRegistryV2 = new MapperRegistryV2(this);
    private Map<String, MapperEntity> mapperEntityMap = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSessionV2 sqlSessionV2) {
        return mapperRegistryV2.getMapper(type, sqlSessionV2);
    }

    public ConfigurationV2 parse() {
        mapperEntityMap.put("com.joaby.easy.study.mybatis.mapper.TestMapper.selectByPrimaryKey", new MapperEntity());
        return this;
    }

    public Map<String, MapperEntity> getMapperEntityMap() {
        return mapperEntityMap;
    }

    public class MapperEntity {
        public String SQL = "select * from test where id = ?";
        public Class RESULTTYPE = Test.class;
    }

}
