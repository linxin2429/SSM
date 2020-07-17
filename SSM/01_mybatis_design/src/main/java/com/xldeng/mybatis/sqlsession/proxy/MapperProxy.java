package com.xldeng.mybatis.sqlsession.proxy;

import com.xldeng.cfg.Mapper;
import com.xldeng.mybatis.utils.Executor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.util.List;
import java.util.Map;

/**
 * @author 邓鑫林
 * @since 2020/7/15 15:30
 */
public class MapperProxy implements InvocationHandler {
    private Map<String, Mapper> mappers;
    private Connection conn;

    public MapperProxy(Map<String, Mapper> mappers,Connection conn) {
        this.mappers = mappers;
        this.conn = conn;
    }

    /**
 * @Description: 用于对方法进行增强，调用selectList方法
 * @Author: xldeng
 * @Date: 2020/7/15 15:31
 * @param proxy:
 * @param method:
 * @param args:
 * @return: java.lang.Object
 **/
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //获取方法名
        String methodName = method.getName();
        //获取方法所在类名
        String className = method.getDeclaringClass().getName();
        //组合key
        String key = className + "." + methodName;
        //获取mappers中的mapper对象
        Mapper mapper = mappers.get(key);
        if (mapper == null){
            throw new IllegalArgumentException("传入的参数有误");
        }
        //调用工具类查询所有
        return new Executor().selectList(mapper,conn);

    }
}