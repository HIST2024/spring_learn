package com.itheima.dao.impl;

import com.itheima.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert() {
        System.out.println("UserDaoImpl insert...");
    }

    public void show(){
        System.out.println("UserDaoImpl show...");
    }
}
