package com.xldeng;

import com.xldeng.dao.UserDao;
import com.xldeng.domain.QueryVo;
import com.xldeng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/15 18:13
 */
public class MybatisTest {
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
        for (User user : userList) {
            System.out.println(user);
        }
    }



    @Test
    public void findById() {
        User user = userDao.findById(50);
        System.out.println(user);
    }
    @Test
    public void findByName() {
        List<User> userList = userDao.findByName("%王%");
        for (User user : userList) {
            System.out.println(user);
        }
    }



    @Test
    public void findByVo() {
        QueryVo queryVo = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        queryVo.setUser(user);
        List<User> userList = userDao.findByVo(queryVo);
        for (User u : userList) {
            System.out.println(u);
        }
    }

    @Test
    public void findUserByCondition() {
        User user = new User();
        user.setUsername("老王");
        List<User> userList = userDao.findUserByCondition(user);
        for (User u : userList) {
            System.out.println(u);
        }
    }

    @Test
    public void findUserInIds() {
        QueryVo queryVo = new QueryVo();
        Integer[] idsArray = {41,43,45,50};
        List<Integer> ids = Arrays.asList(idsArray);
        queryVo.setIds(ids);
        List<User> userList = userDao.findUserInIds(queryVo);
        for (User u : userList) {
            System.out.println(u);
        }
    }
}