package com.joaby.easy.study.mybatis.v2.statement;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/18 19:47
 */
public interface ParameterHandlerV2 {

    <T> T query(PreparedStatement psmt) throws Exception;
}
