package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/**
 * @author codermao
 * @date 2023/2/18 17:06
 */
//构造器注入
public class UserServiceImpl4 implements UserService {

    private Integer age;
    private String name;
    private UserDao dao;

    public UserServiceImpl4(Integer age, String name, UserDao dao) {
        this.age = age;
        this.name = name;
        this.dao = dao;
    }

    @Override
    public void save() {
        System.out.println("user service running 222...");
        System.out.println(name + "," + age);
        dao.insert();
    }

}