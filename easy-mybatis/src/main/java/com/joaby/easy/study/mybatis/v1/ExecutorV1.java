package com.joaby.easy.study.mybatis.v1;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:53
 */
public interface ExecutorV1 {
    <T> T query(String statement, String parameter);
}
