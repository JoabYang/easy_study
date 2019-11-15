package com.joaby.easy.study.mybatis.v2.executor;

import com.joaby.easy.study.mybatis.entity.Test;

import java.sql.*;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/15 21:08
 */
public class SimpleExecutorV2 implements ExecutorV2 {
    @Override
    public <T> T query(String statement, Object parameter, Class<T> resultType) {
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "qq25616804");
//            PreparedStatement psmt = conn.prepareStatement(statement);
//            psmt.setInt(1, (Integer) parameter);
//            ResultSet rs = psmt.executeQuery();
//            Test test = null;
//            while (rs.next()) {
//                test = new Test();
//                test.setId(rs.getInt(1));
//                test.setName(rs.getString(2));
//            }
            Test test = new Test();
            test.setId(1);
            test.setName("JoabY");
            return (T)test;
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
}
