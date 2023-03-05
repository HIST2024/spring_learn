package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

/**
 * @author codermao
 * @date 2023/2/18 17:06
 */
//set注入
public class UserServiceImpl3 implements UserService {

    private Integer age;
    private String name;
    private UserDao dao;

    @Override
    public void save() {
        System.out.println("user service running 222...");
        System.out.println(name + "," + age);
        dao.insert();
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}