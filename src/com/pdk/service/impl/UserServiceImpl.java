package com.pdk.service.impl;

import com.pdk.dao.UserDao;
import com.pdk.dao.impl.UserDaoImpl;
import com.pdk.domain.PageBean;
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

    @Override
    public void addUser(User user) {
        dao.add(user);
    }

    @Override
    public void deleteUserById(String id) {
        dao.deleteUserById(Integer.parseInt(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findUserById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] ids) {
        if (ids != null && ids.length > 0) {
            for (String id : ids) {
                dao.deleteUserById(Integer.parseInt(id));
            }
        }

    }

    @Override
    public PageBean<User> findUserByPage(String _currentPage, String _rows) {
        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);
        PageBean<User> pageBean=new PageBean<User>();
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        //查询总条目
//       int totalCount=dao.findTotalCount();
//        pageBean.setTotalCount(totalCount);
//        //计算开始查询的索引
//        int start=(currentPage-1)*rows;
//        List<User> userList=dao.findByPageList(start,rows);
//        pageBean.setLis(userList);
//        pageBean.setTotalPage();


        return null;
    }
}
