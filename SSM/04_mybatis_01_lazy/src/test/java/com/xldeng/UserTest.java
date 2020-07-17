package com.xldeng;

import com.xldeng.dao.AccountDao;
import com.xldeng.dao.UserDao;
import com.xldeng.domain.Account;

import com.xldeng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/15 18:13
 */
public class UserTest {
    private InputStream in;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll() {
        List<User> userList = userDao.findAll();
//        for (User user : userList) {
//            System.out.println("_____每个user_______");
//            System.out.println(user);
//            System.out.println(user.getAccounts());
//        }
    }


}