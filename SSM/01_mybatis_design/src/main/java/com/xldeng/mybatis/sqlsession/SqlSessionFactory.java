package com.xldeng.mybatis.sqlsession;

/**
 * @author 邓鑫林
 * @since 2020/7/15 14:23
 */
public interface SqlSessionFactory {
/**
 * @Description: 打开一个新的 SqlSession 对象
 * @Author: xldeng
 * @Date: 2020/7/15 14:26

 * @return: com.xldeng.sqlsession.SqlSession
 **/
    SqlSession openSession();
}