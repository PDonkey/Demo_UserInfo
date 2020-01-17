package com.pdk.service.impl;

import com.pdk.dao.UserDao;
import com.pdk.dao.impl.UserDaoImpl;
import com.pdk.domain.User;
import com.pdk.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public User login(User user) {
        return dao.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}