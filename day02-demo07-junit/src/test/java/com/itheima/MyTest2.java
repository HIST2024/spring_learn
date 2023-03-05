package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author codermao
 * @date 2023/2/20 19:57
 */
/*
* TODO:spring整合junit
* */
//SpringJUnit4ClassRunner替代junit原生执行器
@RunWith(SpringJUnit4ClassRunner.class)
//加载注解配置类的
@ContextConfiguration(classes=SpringConfig.class)
public class MyTest2 {
    //自动装配依赖ioc容器
    @Autowired
    AccountService service;
    //idea识别问题，这里没错
    @Autowired
    AccountDao dao;

    @Test
    public void mehod01(){
        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void method2(){
        Account account = dao.findById(1);
        System.out.println("account = " + account);
    }
}
