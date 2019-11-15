package com.joaby.easy.study.mybatis.v2.session;

import com.joaby.easy.study.mybatis.v2.config.ConfigurationV2;
import com.joaby.easy.study.mybatis.v2.executor.ExecutorV2;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:53
 */
public class DefaultSqlSessionV2 implements SqlSessionV2 {

    private ConfigurationV2 configurationV2;
    private ExecutorV2 executorV2;

    public DefaultSqlSessionV2(ConfigurationV2 configurationV2, ExecutorV2 executorV2) {
        this.configurationV2 = configurationV2;
        this.executorV2 = executorV2;
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return configurationV2.getMapper(type, this);
    }

    @Override
    public <T> T selectOne(String statement, Object parameter, Class<T> resultType) {
        return executorV2.query(statement, parameter, resultType);
    }
}
