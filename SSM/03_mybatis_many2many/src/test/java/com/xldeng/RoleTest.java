package com.xldeng;

import com.xldeng.dao.RoleDao;
import com.xldeng.dao.UserDao;
import com.xldeng.domain.Role;
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
public class RoleTest {
    private InputStream in;
    private SqlSession sqlSession;
    private RoleDao roleDao;

    @Before //用于在测试方法执行之前执行
    public void init() throws Exception {
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        sqlSession = sqlSessionFactory.openSession();
        roleDao= sqlSession.getMapper(RoleDao.class);
    }

    @After //用于在测试方法执行之后执行
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }

    @Test
    public void findAll() {
        List<Role> roles = roleDao.findAll();
        for (Role role : roles) {
            System.out.println("---role---");
            System.out.println(role);
            System.out.println(role.getUsers());
        }
    }



}