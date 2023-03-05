package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;


public class UserServiceImpl3 implements UserService {

    private String name;
    private Integer age ;

    private UserDao dao;

    public UserServiceImpl3() {
    }

    public UserServiceImpl3(String name, Integer age, UserDao dao) {
        this.name = name;
        this.age = age;
        this.dao = dao;
    }

    public  void save() {
        System.out.println("user service running222...");
        System.out.println(name + "," + age);
        dao.insert();
    }


}
