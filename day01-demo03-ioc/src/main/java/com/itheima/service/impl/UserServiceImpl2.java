package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;

import java.io.Serializable;

/*
    JavaBean / POJO : java标准实体类
    1. 这个类要实现Serializable接口
    2. 要有public 空参构造
    3. 要有private 属性
    4. 要有public get/set方法
 */
public class UserServiceImpl2 implements UserService {

    private String name;
    private Integer age ;

    private UserDao dao;

    public  void save() {
        System.out.println("user service running222...");
        System.out.println(name + "," + age);
        dao.insert();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public UserDao getDao() {
        return dao;
    }

    public void setDao(UserDao dao) {
        this.dao = dao;
    }
}
