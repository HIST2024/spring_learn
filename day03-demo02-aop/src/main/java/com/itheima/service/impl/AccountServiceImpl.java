package com.itheima.service.impl;

import com.itheima.service.AccountService;
import org.springframework.stereotype.Service;

/**
 * @author codermao
 * @date 2023/2/21 20:10
 */
@Service
public class AccountServiceImpl implements AccountService {
    @Override
    public String findAll() {
        System.out.println("findAll.............");
        return "result: 查询结果";
    }

    @Override
    public void insert(String str) {
        System.out.println("insert............." + str);
//        int i = 1/0;
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
