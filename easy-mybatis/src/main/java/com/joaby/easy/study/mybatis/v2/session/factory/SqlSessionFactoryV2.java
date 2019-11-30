package com.joaby.easy.study.mybatis.v2.session.factory;

import com.joaby.easy.study.mybatis.v2.config.ConfigurationV2;
import com.joaby.easy.study.mybatis.v2.executor.CachingExecutorV2;
import com.joaby.easy.study.mybatis.v2.executor.ExecutorV2;
import com.joaby.easy.study.mybatis.v2.executor.SimpleExecutorV2;
import com.joaby.easy.study.mybatis.v2.session.DefaultSqlSessionV2;
import com.joaby.easy.study.mybatis.v2.session.SqlSessionV2;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 20:54
 */
public class SqlSessionFactoryV2 {

    private boolean cacheEnabled = false;
    enum ExecutorType {
        SIMPLE
    }

    private ConfigurationV2 configurationV2;

    public SqlSessionFactoryV2(ConfigurationV2 configurationV2) {
        this.configurationV2 = configurationV2;
    }

    public SqlSessionV2 openSession() throws Exception {
        return openSession(ExecutorType.SIMPLE);
    }

    public SqlSessionV2 openSession(ExecutorType type) throws Exception {
        ExecutorV2 executorV2;
        if (type == ExecutorType.SIMPLE) {
            executorV2 =  new SimpleExecutorV2();
        } else {
            throw new Exception();
        }
        if (cacheEnabled) {
            executorV2 = new CachingExecutorV2(executorV2);
        }
        return new DefaultSqlSessionV2(configurationV2, executorV2);
    }


}
