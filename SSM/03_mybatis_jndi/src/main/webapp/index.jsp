<%@ page import="java.io.InputStream" %>
<%@ page import="org.apache.ibatis.io.Resources" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSessionFactory" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>
<%@ page import="com.xldeng.dao.UserDao" %>
<%@ page import="com.xldeng.domain.User" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<body>
<h2>Hello World!</h2>
<%
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
%>
</body>
</html>
