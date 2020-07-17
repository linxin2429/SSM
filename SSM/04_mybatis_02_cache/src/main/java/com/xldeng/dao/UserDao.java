package com.xldeng.dao;


import com.xldeng.domain.User;

import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/15 18:11
 */
public interface UserDao {
    /**
     * @Description: 查询所有用户
     * @Author: xldeng
     * @Date: 2020/7/15 18:24
     * @return: java.util.List<com.xldeng.domain.User>
     **/
    List<User> findAll();

    User findById(Integer userId);

    void updateUser(User user);
}