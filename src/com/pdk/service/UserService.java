package com.pdk.service;

import com.pdk.domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll();

    public User login(User user);

    /**
     * 存储用户信息
     * @param user
     */
    void addUser(User user);
}
