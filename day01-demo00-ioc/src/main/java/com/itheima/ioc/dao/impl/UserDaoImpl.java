package com.itheima.ioc.dao.impl;

import com.itheima.ioc.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void addUser() {
        System.out.println("添加用户");
    }

    @Override
    public void deleteUser() {
        System.out.println("删除用户");
    }

    @Override
    public void updateUser() {
        System.out.println("修改用户");
    }

    @Override
    public void queryUser() {
        System.out.println("查询用户");
    }
}
