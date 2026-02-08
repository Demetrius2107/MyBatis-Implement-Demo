package com.shanyue.mybatis.session;

/**
 * 工厂接口模式，构建SqlSession工厂
 */
public interface SqlSessionFactory {

    /**
     * 打开一个Session
     */
    SqlSession openSession();

}
