package com.joaby.easy.study.mybatis.v2.executor;

import com.joaby.easy.study.mybatis.v2.statement.DefaultResultSetHandlerV2;
import com.joaby.easy.study.mybatis.v2.statement.PreparedStatementHandlerV2;

import java.sql.*;
import java.util.List;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 21:08
 */
public class SimpleExecutorV2 implements ExecutorV2 {
    @Override
    public <T> T query(String sql, Object parameter, Class<T> resultType, List<String> fieldNames) {
        Connection conn = null;
        try {
            conn = getConnection();
            PreparedStatementHandlerV2 handler = new PreparedStatementHandlerV2(sql, parameter, resultType, fieldNames);
            PreparedStatement psmt = prepareStatement(handler, conn);
            return handler.query(psmt);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "qq25616804");
    }

    private PreparedStatement prepareStatement(PreparedStatementHandlerV2 handler, Connection conn) throws Exception {
        PreparedStatement psmt = handler.prepare(conn);
        handler.parameterize(psmt);
        return psmt;
    }
}
