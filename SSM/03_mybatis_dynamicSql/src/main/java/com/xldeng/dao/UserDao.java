package com.xldeng.dao;

import com.xldeng.domain.QueryVo;
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

    List<User> findByName(String userName);


    /**
     * @param vo:
     * @Description: 根据QueryVo中的条件查询用户
     * @Author: xldeng
     * @Date: 2020/7/15 23:02
     * @return: int
     **/
    List<User> findByVo(QueryVo vo);

    /**
     * @Description: 根据条件查询
     * @Author: xldeng
     * @Date: 2020/7/16 10:25
     * @return: java.util.List<com.xldeng.domain.User>
     **/
    List<User> findUserByCondition(User user);

    /**
     * @param vo:
     * @Description: 根据QueryVo中的ids查询
     * @Author: xldeng
     * @Date: 2020/7/16 10:46
     * @return: java.util.List<com.xldeng.domain.User>
     **/
    List<User> findUserInIds(QueryVo vo);
}