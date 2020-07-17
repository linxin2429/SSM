package com.xldeng.dao;

import com.xldeng.domain.User;
import com.xldeng.mybatis.annotations.Select;

import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/14 23:22
 * 用户的持久层接口
 */
public interface UserDao {
    /**
     * @Description: 查询所有操作
     * @Author: xldeng
     * @Date: 2020/7/14 23:24

     * @return: java.util.List<com.xldeng.domain.User>
     **/
    @Select("select * from user")
    List<User> findAll();
}