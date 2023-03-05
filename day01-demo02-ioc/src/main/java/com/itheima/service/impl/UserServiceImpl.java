package com.itheima.service.impl;


import com.itheima.service.UserService;

/**
 * @author codermao
 * @date 2023/2/18 17:06
 */
public class UserServiceImpl implements UserService {

    public UserServiceImpl() {
        System.out.println("UserServiceImpl constructor ...");
    }

    public void save() {
        System.out.println("userService save running...");
    }

    public void init(){
        System.out.println("initt...");
    }

    public void destory(){
        /*
        * 打印是一个耗时操作，IO流
        * */
        System.out.println("destoryy...");
    }
}