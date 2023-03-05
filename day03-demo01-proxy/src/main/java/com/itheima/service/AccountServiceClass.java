package com.itheima.service;

public class AccountServiceClass {

    public String findAll() {
        System.out.println("findAll.............");
        return "result: 查询结果";
    }

    //注意CGLIB中final方法不能被增强,final修饰的方法不能被重写
    public void insert(String str) {
        System.out.println("insert............." + str);
        try {
            int i = 1 / 0;
        } catch (Exception e) {
//            e.printStackTrace();
        }
    }


    public void update() {
        System.out.println("update.............");
    }


    public void delete() {
        System.out.println("delete.............");
    }
}
