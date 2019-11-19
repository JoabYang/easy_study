package com.joaby.easy.study.mybatis.v2.statement;

import java.sql.PreparedStatement;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/19 14:29
 */
public interface ResultSetHandlerV2 {

    <T> T handleResultSets(PreparedStatement psmt) throws Exception;
}
