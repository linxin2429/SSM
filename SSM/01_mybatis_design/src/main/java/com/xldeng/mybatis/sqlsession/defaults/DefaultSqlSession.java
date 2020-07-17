package com.xldeng.mybatis.sqlsession.defaults;

import com.xldeng.cfg.Configuration;
import com.xldeng.mybatis.sqlsession.SqlSession;
import com.xldeng.mybatis.sqlsession.proxy.MapperProxy;
import com.xldeng.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 邓鑫林
 * @since 2020/7/15 15:20
 */
public class DefaultSqlSession implements SqlSession {
    private Configuration cfg;
    private Connection connection;

    public DefaultSqlSession(Configuration cfg) {
        this.cfg = cfg;
        connection = DataSourceUtil.getConnection(cfg);
    }

    /**
     * @param daoInterfaceClass:
     * @Description: 用于创建代理对象
     * @Author: xldeng
     * @Date: 2020/7/15 15:22
     * @return: T
     **/
    public <T> T getMapper(Class<T> daoInterfaceClass) {
       return (T) Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass},
               new MapperProxy(cfg.getMappers(), connection));

    }

    /**
     * @Description: 关闭资源
     * @Author: xldeng
     * @Date: 2020/7/15 15:22
     * @return: void
     **/
    public void close() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}