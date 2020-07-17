package com.xldeng.dao;

import com.xldeng.domain.Account;
import com.xldeng.domain.AccountUser;

import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/16 15:24
 */
public interface AccountDao {
    /**
     * @Description: 查询所有账户，同时获取当前账户的所属用户信息
     * @Author: xldeng
     * @Date: 2020/7/16 15:30

     * @return: java.util.List<com.xldeng.domain.Account>
     **/
    List<Account> findAll();
    /**
     * @Description: 查询所有账户并带有用户名称和地址信息
     * @Author: xldeng
     * @Date: 2020/7/16 15:34

     * @return: java.util.List<com.xldeng.domain.Account>
     **/
    List<AccountUser> findAllAccount();
}
