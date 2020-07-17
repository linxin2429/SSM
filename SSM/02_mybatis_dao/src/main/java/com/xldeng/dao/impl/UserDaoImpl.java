package com.xldeng.dao.impl;

import com.xldeng.dao.UserDao;
import com.xldeng.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/16 0:33
 */
public class UserDaoImpl implements UserDao {
    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    public List<User> findAll() {
        //根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //调用SQLSession中的方法完成查询
        List<User> users = sqlSession.selectList("com.xldeng.dao.UserDao.findAll");//参数是能获取配置信息的key
        //释放资源
        sqlSession.close();
        return users;
    }

    public void saveUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.insert("com.xldeng.dao.UserDao.saveUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void updateUser(User user) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.update("com.xldeng.dao.UserDao.updateUser",user);
        sqlSession.commit();
        sqlSession.close();
    }

    public void deleteUser(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        sqlSession.delete("com.xldeng.dao.UserDao.deleteUser",userId);
        sqlSession.commit();
        sqlSession.close();
    }

    public User findById(Integer userId) {
        SqlSession sqlSession = factory.openSession();
        User user = sqlSession.selectOne("com.xldeng.dao.UserDao.findById", userId);
        sqlSession.close();
        return user;
    }

    public List<User> findByName(String userName) {
        //根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //调用SQLSession中的方法完成查询
        List<User> users = sqlSession.selectList("com.xldeng.dao.UserDao.findByName",userName);//参数是能获取配置信息的key
        //释放资源
        sqlSession.close();
        return users;
    }

    public int findTotal() {
        //根据factory获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //调用SQLSession中的方法完成查询
        Integer count = sqlSession.selectOne("com.xldeng.dao.UserDao.findTotal");//参数是能获取配置信息的key
        //释放资源
        sqlSession.close();
        return count;
    }
}