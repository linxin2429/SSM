package com.xldeng.dao;

import com.xldeng.domain.Role;

import java.util.List;

/**
 * @author 邓鑫林
 * @since 2020/7/16 17:36
 */
public interface RoleDao {
    List<Role> findAll();
}
