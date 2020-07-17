package com.xldeng;

import com.xldeng.dao.UserDao;
//import com.xldeng.domain.QueryVo;
import com.xldeng.dao.impl.UserDaoImpl;
import com.xldeng.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
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
        userDao = new UserDaoImpl(sqlSessionFactory);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception {
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
    public void saveUser() {
        User user = new User();
        user.setUsername("mybatis impl saveuser");
        user.setBirthday(new Date());
        user.setAddress("武汉市洪山区");
        user.setSex("男");
        System.out.println(user);
        userDao.saveUser(user);
        System.out.println(user);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(50);
        user.setUsername("mybatis Update impl user");
        user.setBirthday(new Date());
        user.setAddress("武汉市洪山区");
        user.setSex("女");
        userDao.updateUser(user);
    }

    @Test
    public void deleteUser() {
        userDao.deleteUser(51);
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
    public void findTotal() {
        int count = userDao.findTotal();
        System.out.println(count);
    }

//    @Test
//    public void findByVo() {
//        QueryVo queryVo = new QueryVo();
//        User user = new User();
//        user.setUserName("%王%");
//        queryVo.setUser(user);
//        List<User> userList = userDao.findByVo(queryVo);
//        for (User u : userList) {
//            System.out.println(u);
//        }
//    }
}