package com.joaby.easy.study.mybatis.v2.statement;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/19 14:29
 */
public class DefaultResultSetHandlerV2 implements ResultSetHandlerV2 {

    private Class resultType;
    private List<String> fieldNames;

    public DefaultResultSetHandlerV2(Class resultType, List<String> fieldNames) {
        this.resultType = resultType;
        this.fieldNames = fieldNames;
    }

    @Override
    public <T> T handleResultSets(PreparedStatement psmt) throws Exception {
        ResultSet rs = psmt.getResultSet();
        Object obj = null;
        while (rs.next()) {
            obj = resultType.newInstance();
            for (int i = 0; i < fieldNames.size(); i++) {
                String methodName = "set" + toUpperCaseForFirstChar(fieldNames.get(i));
                if (i == 0) {
                    resultType.getMethod(methodName, Integer.class).invoke(obj, rs.getInt(i + 1));
                } else {
                    resultType.getMethod(methodName, String.class).invoke(obj, rs.getString(i + 1));
                }
            }
        }
        return (T)obj;
    }

    private String toUpperCaseForFirstChar(String str) {
        char[] chars = str.toCharArray();
        chars[0] -= 32;
        return String.valueOf(chars);
    }
}
