package com.joaby.easy.study.mybatis.v2.executor;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:48
 */
public interface ExecutorV2 {
    <T> T query(String statement, Object parameter, Class<T> resultType);
}
