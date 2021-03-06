package com.pdk.service;

import com.pdk.domain.PageBean;
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

    /**
     * 根据用户的id删除用户信息
     * @param id
     */
    void deleteUserById(String id);

    /**
     * 根据id查询用户
     * @param id
     * @return
     */
    User findUserById(String id);

    /**
     * 更新用户信息
     * @param user
     */
    void updateUser(User user);

    /**
     * 删除选中的用户信息
     * @param ids
     */
    void delSelectedUser(String[] ids);

    /**
     * 查询一页数据
     * @param currentPage
     * @param rows
     * @return
     */
    PageBean<User> findUserByPage(String currentPage, String rows);
}
