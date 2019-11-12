package com.joaby.easy.study.mybatis.test;

import com.joaby.easy.study.mybatis.mapper.TestMapper;
import com.joaby.easy.study.mybatis.v1.MyConfiguration;
import com.joaby.easy.study.mybatis.v1.MySimpleExecutor;
import com.joaby.easy.study.mybatis.v1.MySqlSession;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:57
 */
public class TestMain {
    public static void main(String[] args) {
//        try {
//            FileInputStream fis = new FileInputStream();
//            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
//            SqlSessionFactory factory = builder.build(fis);
//            SqlSession sqlSession = factory.openSession();
//            sqlSession.getMapper(TestMapper.class);
//        } catch (Exception e) {
//
//        }
        MySqlSession sqlSession = new MySqlSession(new MyConfiguration(), new MySimpleExecutor());
        TestMapper mapper = sqlSession.getMapper(TestMapper.class);
        System.out.println(mapper.selectByPrimaryKey(1));
    }
}
