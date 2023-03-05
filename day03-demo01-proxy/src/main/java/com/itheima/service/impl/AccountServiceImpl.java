package com.itheima.service.impl;

import com.itheima.service.AccountService;

public class AccountServiceImpl implements AccountService {
    @Override
    public String findAll() {
        System.out.println("findAll.............");
        return "result: 查询结果";
    }

    @Override
    public void insert(String str) {
        System.out.println("insert............." + str);
      /*  try {
            int i = 1/0;
        } catch (Exception e) {
            throw new RuntimeException();
        }*/
    }

    @Override
    public void update() {
        System.out.println("update.............");
    }

    @Override
    public void delete() {
        System.out.println("delete.............");
    }
}
