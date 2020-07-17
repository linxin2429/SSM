package com.xldeng.mybatis.sqlsession;

import com.xldeng.dao.UserDao;

/**
 * @author 邓鑫林
 * @since 2020/7/15 14:23
 * 自定义Mybatis中和数据库交互的核心类，创建 dao 接口的代理对象
 */
public interface SqlSession {
    /**
     * @Description: 创建一个代理对象
     * @Author: xldeng
     * @Date: 2020/7/15 14:28
     * @param daoInterfaceClass: dao接口字节码
     * @return: T
     **/
     <T> T getMapper(Class<T> daoInterfaceClass);
/**
 * @Description: 释放资源
 * @Author: xldeng
 * @Date: 2020/7/15 14:30

 * @return: void
 **/
    void close();
}