package com.joaby.easy.study.mybatis.v2.session.factory;

import com.joaby.easy.study.mybatis.v2.config.ConfigurationV2;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 20:54
 */
public class SqlSessionFactoryBuilderV2 {

    public SqlSessionFactoryV2 build() {
        ConfigurationV2 configurationV2 = new ConfigurationV2().parse();
        return build(configurationV2);
    }

    public SqlSessionFactoryV2 build(ConfigurationV2 configurationV2) {
        return new SqlSessionFactoryV2(configurationV2);
    }
}
