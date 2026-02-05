package com.shanyue.mybatis.binding;

import java.lang.reflect.Proxy;
import java.util.Map;

/**
 * @author shanyue
 * @description 映射器代理工厂
 *
 */
@SuppressWarnings("unchecked")
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(Map<String, String> sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }


}
