package com.xldeng.mybatis.sqlsession;

import com.xldeng.cfg.Configuration;
import com.xldeng.mybatis.sqlsession.defaults.DefaultSqlSessionFactory;
import com.xldeng.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * @author 邓鑫林
 * @since 2020/7/15 14:21
 * 创建SqlSessionFactory对象
 */
public class SqlSessionFactoryBuilder {
/**
 * @Description: 根据字节输入流构建 SqlSessionFactory工厂
 * @Author: xldeng
 * @Date: 2020/7/15 14:30
 * @param config:
 * @return: com.xldeng.sqlsession.SqlSessionFactory
 **/
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);

        return new DefaultSqlSessionFactory(cfg);
    }
}