package com.joaby.easy.study.mybatis.v1;

import com.joaby.easy.study.mybatis.entity.Test;

import java.sql.*;

public class MySimpleExecutor implements MyExecutor {

    @Override
    public <T> T query(String statement, String parameter) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?useUnicode=true&characterEncoding=UTF-8", "root", "qq25616804");
            PreparedStatement psmt = conn.prepareStatement(statement);
            psmt.setInt(1, Integer.valueOf(parameter));
            ResultSet rs = psmt.executeQuery();
            Test test = null;
            while (rs.next()) {
                test = new Test();
                test.setId(rs.getInt(1));
                test.setName(rs.getString(2));
            }
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
