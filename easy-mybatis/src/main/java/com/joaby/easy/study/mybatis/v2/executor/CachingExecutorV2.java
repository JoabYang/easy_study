package com.joaby.easy.study.mybatis.v2.executor;

import java.util.List;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/19 20:13
 */
public class CachingExecutorV2 implements ExecutorV2 {

    public ExecutorV2 delegate;

    public CachingExecutorV2(ExecutorV2 executorV2) {
        this.delegate = executorV2;
    }

    @Override
    public <T> T query(String sql, Object parameter, Class<T> resultType, List<String> fieldNames) {
        T t = searchFromCache();
        if (t != null) {
            return t;
        }
        return delegate.query(sql, parameter, resultType, fieldNames);
    }

    private <T> T searchFromCache() {
        return null;
    }
}
