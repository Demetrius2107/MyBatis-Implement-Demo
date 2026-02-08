package com.shanyue.mybatis.binding;

import com.shanyue.mybatis.session.SqlSession;

import java.util.HashMap;
import java.util.Map;

/**
 * 映射器注册机
 */
public class MapperRegistry {

    /**
     * 将已添加的映射器代理加入到HashMap
     */
    private final Map<Class<?>, MapperProxyFactory<?>> knownMappers = new HashMap<>();

    public <T> T getMapper(Class<T> type, SqlSession sqlSession) {
        final MapperProxyFactory<T> mapperProxyFactory = (MapperProxyFactory<T>) knownMappers.get(type);
        if (mapperProxyFactory == null) {
            throw new RuntimeException("Type " + type + " is not known to the MapperRegistry.");
        }
        try {
            return mapperProxyFactory.newInstance(sqlSession);
        } catch (Exception e) {
            throw new RuntimeException("Error getting mapper instance.Cause: " + e, e);
        }

    }

    public <T> void addMapper(Class<T> type) {
        /**
         * Mapper必须是接口才能进行注册
         */
        if (type.isInterface()) {
            // 重复添加报错
            if (hasMapper(type)) {
                throw new RuntimeException("Type " + type + "is already known to the MapperRegistry.");
            }
            // 注册映射器代理工厂
            knownMappers.put(type, new MapperProxyFactory<>(type));
        }
    }


    public <T> boolean hasMapper(Class<T> type) {
        return knownMappers.containsKey(type);
    }


}
