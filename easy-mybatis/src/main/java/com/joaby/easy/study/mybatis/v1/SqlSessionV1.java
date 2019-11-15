package com.joaby.easy.study.mybatis.v1;


/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:53
 */
public class SqlSessionV1 {
    private ConfigurationV1 configuration;
    private ExecutorV1 excutor;

    public SqlSessionV1(ConfigurationV1 configuration, ExecutorV1 excutor) {
        this.configuration = configuration;
        this.excutor = excutor;
    }

    public <T> T getMapper(Class<T> type) {
        return configuration.getMapper(type, this);
    }

    public <T> T selectOne(String statement, String parameter) {
        return (T) excutor.query(statement, parameter);
    }

}
