package com.itheima.service;

import org.springframework.stereotype.Service;

/**
 * @author codermao
 * @date 2023/2/21 20:10
 */
//目标对象，放到ioc容器中
@Service
public class AccountServiceClass {
    public String findAll() {
        System.out.println("findAll.............");
        return "result: 查询结果";
    }

    public void insert(String str) {
        System.out.println("insert............." + str);
//        int i = 1/0;
    }

    public void update() {
        System.out.println("update.............");
    }

    public void delete() {
        System.out.println("delete.............");
    }
}
