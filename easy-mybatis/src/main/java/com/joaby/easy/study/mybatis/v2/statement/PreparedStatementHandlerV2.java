package com.joaby.easy.study.mybatis.v2.statement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/18 19:50
 */
public class PreparedStatementHandlerV2 implements ParameterHandlerV2 {

    private String sql;
    private Object parameter;
    private DefaultResultSetHandlerV2 resultSetHandlerV2;

    public PreparedStatementHandlerV2(String sql, Object parameter, Class resultType, List<String> fieldNames) {
        this.sql = sql;
        this.parameter = parameter;
        this.resultSetHandlerV2 = new DefaultResultSetHandlerV2(resultType, fieldNames);
    }

    @Override
    public <T> T query(PreparedStatement psmt) throws Exception {
        psmt.execute();
        return resultSetHandlerV2.handleResultSets(psmt);
    }

    public PreparedStatement prepare(Connection conn) throws SQLException {
        return conn.prepareStatement(sql);
    }

    public void parameterize(PreparedStatement psmt) throws SQLException {
        psmt.setInt(1, (Integer) parameter);
    }
}
