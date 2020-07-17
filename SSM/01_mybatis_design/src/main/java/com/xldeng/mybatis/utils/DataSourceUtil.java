package com.xldeng.mybatis.utils;

import com.xldeng.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;


/**
 * @author 邓鑫林
 * @since 2020/7/15 15:52
 */
public class DataSourceUtil {

    public static Connection getConnection(Configuration cfg) {
        try {
            Class.forName(cfg.getDriver());
            return DriverManager.getConnection(cfg.getUrl(),cfg.getUsername(),cfg.getPassword());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}