package com.joaby.easy.study.mybatis.test;

import com.joaby.easy.study.mybatis.mapper.TestMapper;
import com.joaby.easy.study.mybatis.v1.ConfigurationV1;
import com.joaby.easy.study.mybatis.v1.SimpleExecutorV1;
import com.joaby.easy.study.mybatis.v1.SqlSessionV1;
import com.joaby.easy.study.mybatis.v2.session.SqlSessionV2;
import com.joaby.easy.study.mybatis.v2.session.factory.SqlSessionFactoryBuilderV2;
import com.joaby.easy.study.mybatis.v2.session.factory.SqlSessionFactoryV2;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.FileInputStream;

/**
 * @author: yangjianbo
 * @Date: Created in 2019/11/12 15:57
 */
public class TestMain {
    public static void main(String[] args) {
        // 原生mybatis
//        try {
//            FileInputStream fis = new FileInputStream("");
//            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(fis);
//            SqlSession sqlSession = factory.openSession();
//            TestMapper mapper = sqlSession.getMapper(TestMapper.class);
//            System.out.println(mapper.selectByPrimaryKey(1));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        // v1版
//        SqlSessionV1 sqlSessionV1 = new SqlSessionV1(new ConfigurationV1(), new SimpleExecutorV1());
//        TestMapper mapperV1 = sqlSessionV1.getMapper(TestMapper.class);
//        System.out.println(mapperV1.selectByPrimaryKey(1));

        // v2版
        try {
            SqlSessionFactoryV2 factoryV2 = new SqlSessionFactoryBuilderV2().build();
            SqlSessionV2 sqlSessionV2 = factoryV2.openSession();
            TestMapper mapperV2 = sqlSessionV2.getMapper(TestMapper.class);
            System.out.println(mapperV2.selectByPrimaryKey(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
