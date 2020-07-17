package com.xldeng.mybatis.sqlsession.defaults;

import com.xldeng.cfg.Configuration;
import com.xldeng.mybatis.sqlsession.SqlSession;
import com.xldeng.mybatis.sqlsession.SqlSessionFactory;

/**
 * @author 邓鑫林
 * @since 2020/7/15 15:08
 * SqlSessionFactory接口实现类
 */
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private Configuration cfg;

    public DefaultSqlSessionFactory(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
 * @Description: 用于创建一个新的操作数据库对象
 * @Author: xldeng
 * @Date: 2020/7/15 15:09

 * @return: com.xldeng.mybatis.sqlsession.SqlSession
 **/
    public SqlSession openSession() {
        return new DefaultSqlSession(cfg);
    }
}