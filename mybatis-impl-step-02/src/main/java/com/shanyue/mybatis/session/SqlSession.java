package com.shanyue.mybatis.session;


/**
 * 执行SQL 获取映射器，管理事务
 */
public interface SqlSession {

    /**
     * 根据指定的SqlID获取一条记录的封装对象
     * @param statement sqlID
     * @return Mapped Objected 封装之后的对象
     * @param <T>
     */
    <T> T selectOne(String statement);

    /**
     * 根据指定的SQLID获取一条记录的封装对象，给SQL传递参数-pojo Map ImmutableMap
     *
     * @param statement
     * @param parameter
     * @return
     * @param <T>
     */
    <T> T selectOne(String statement, Object parameter);

    /**
     * 得到映射器 使用泛型 保证类型按转
     * @param type
     * @return
     * @param <T>
     */
    <T> T getMapper(Class<T> type);

}
