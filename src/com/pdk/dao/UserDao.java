package com.pdk.dao;

import com.pdk.domain.User;

import java.util.List;

/**
 * 用户操作的Dao
 */
public interface UserDao {
    public List<User> findAll();

    public User findUserByUsernameAndPassword(String username,String password);

    void add(User user);

    void deleteUserById(int id);

    User findUserById(int id);
}
