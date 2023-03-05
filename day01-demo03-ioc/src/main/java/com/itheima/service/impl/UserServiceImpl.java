package com.itheima.service.impl;

import com.itheima.service.UserService;

public class UserServiceImpl implements UserService {
    public UserServiceImpl(){
        System.out.println("UserServiceImpl 空参构造执行了...");
    }
    public  void save() {
        System.out.println("user service running...");
    }
    public static void show() {
        System.out.println("user service show...");
    }

    public void init(){
        System.out.println("service init...");
    }

    public void destroy(){
        System.out.println("service destroy...");
    }

    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        int j = 0;
        for (int i = 0; i < 10000; i++) {
//            j++;
            System.out.println(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println(endTime-startTime);
    }
}
