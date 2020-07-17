package com.xldeng.test;

import com.xldeng.dao.UserDao;
import com.xldeng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/17 0:25
 */
public class AnnotationCRUDTest {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession sqlSession;
    private UserDao userDao;

    @Before
    public void init() throws IOException {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        factory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = factory.openSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }
    @After
    public void destroy() throws IOException {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void testSave(){
        User user = new User();
        user.setUsername("mybatis annotation");
        user.setAddress("湖北省武汉市");
        user.setSex("女");
        userDao.saveUser(user);

    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(55);
        user.setUsername("mybatis annotation update");
        user.setAddress("湖北省武汉市");
        user.setSex("女");
        user.setBirthday(new Date());
        userDao.updateUser(user);

    }

    @Test
    public void testDelete(){
        userDao.deleteUser(55);
    }

    @Test
    public void testFindById(){
        User user = userDao.findById(54);
        System.out.println(user);
    }

    @Test
    public void testFindByName(){
        List<User> users = userDao.findUserByName("%mybatis%");
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testFindTotal(){
        System.out.println(userDao.findTotal());
    }
}