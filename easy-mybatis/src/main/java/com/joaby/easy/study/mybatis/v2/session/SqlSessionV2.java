package com.joaby.easy.study.mybatis.v2.session;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 19:45
 */
public interface SqlSessionV2 {

    <T> T getMapper(Class<T> type);

    <T> T selectOne(String statement, Object parameter, Class<T> resultType);
}
