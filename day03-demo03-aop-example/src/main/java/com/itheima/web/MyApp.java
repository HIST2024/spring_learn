package com.itheima.web;

import com.itheima.config.SpringConfig;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author codermao
 * @date 2023/2/21 20:14
 */
/*
 * TODO:AOP小案例
 *       计算service层所有find开头方法执行10000次的耗时
 * */
//spring整合junit
@RunWith(SpringJUnit4ClassRunner.class)
//加载注解配置类
@ContextConfiguration(classes = SpringConfig.class)
public class MyApp {
    @Autowired
    AccountService service;

    @Test
    public void test01() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.findAll();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findAll耗时:" + (endTime - startTime));
    }
    @Test
    public void test02() {
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            service.findById(i);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("findById耗时:" + (endTime - startTime));
    }

    @Test
    public void test03(){
//        service.findAll(); //String com.itheima.service.AccountService.findAll()耗时:104
        service.findById(2);
    }
}