package com.joaby.easy.study.mybatis.test;

import com.joaby.easy.study.mybatis.mapper.TestMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:57
 */
public class Test {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream();
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(fis);
            SqlSession sqlSession = factory.openSession();
            sqlSession.getMapper(TestMapper.class);
        } catch (Exception e) {

        }
    }
}
