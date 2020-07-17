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
    /**
     * @Description: 保存用户
     * @Author: xldeng
     * @Date: 2020/7/15 18:25
     * @param user:
     * @return: void
     **/
    void saveUser(User user);
    /**
     * @Description: 更新用户
     * @Author: xldeng
     * @Date: 2020/7/15 18:44
     * @param user:
     * @return: void
     **/
    void updateUser(User user);
    /**
     * @Description: 根据id删除用户
     * @Author: xldeng
     * @Date: 2020/7/15 18:44
     * @param userId:
     * @return: void
     **/
    void deleteUser(Integer userId);
    /**
     * @Description: 根据id查找用户
     * @Author: xldeng
     * @Date: 2020/7/15 18:56
     * @param userId:
     * @return: com.xldeng.domain.User
     **/
    User findById(Integer userId);

    List<User> findByName(String userName);

    int findTotal();
    /**
     * @Description: 根据QueryVo中的条件查询用户
     * @Author: xldeng
     * @Date: 2020/7/15 23:02
     * @param vo:
     * @return: int
     **/
    List<User> findByVo(QueryVo vo);
}