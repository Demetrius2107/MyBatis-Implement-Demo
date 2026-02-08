package com.shanyue.mybatis.test;

import com.shanyue.mybatis.binding.MapperRegistry;
import com.shanyue.mybatis.session.SqlSession;
import com.shanyue.mybatis.session.SqlSessionFactory;
import com.shanyue.mybatis.session.defaults.DefaultSqlSessionFactory;
import com.shanyue.mybatis.test.dao.IUserDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class ApiTest{

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_MapperProxyFactory(){

        // 1. 注册Mapper
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("com.shanyue.mybatis.test.dao");

        // 2.从SqlSession工厂获取Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        // 3.获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);

        //验证测试
        String res = userDao.queryUserName("10001");
        logger.info("测试结果:{}",res);
    }

}
