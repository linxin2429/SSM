package com.xldeng;






import com.xldeng.dao.UserDao;
import com.xldeng.domain.User;

import com.xldeng.mybatis.io.Resources;
import com.xldeng.mybatis.sqlsession.SqlSession;
import com.xldeng.mybatis.sqlsession.SqlSessionFactory;
import com.xldeng.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/15 0:18
 * 入门案例
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        // 2.创建SqlSessionFactory的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        // 3.使用构建者创建工厂对象
        SqlSessionFactory sqlSessionFactory = builder.build(in);
        // 4.使用SqlSessionFactory生产SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 5.使用SqlSession创建dao接口的代理对象
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        // 6.使用代理对象执行查询所有方法
        List<User> userList = userDao.findAll();
        for (User user : userList) {
            System.out.println(user);
        }
        // 7.释放资源
        sqlSession.close();
        in.close();
    }
}