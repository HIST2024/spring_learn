package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
    TODO：spring和mybatis
* 最初版的spring和mybatis
*   1.mybatis核心配置文件
*   2.mybatis工具类：SqlSessionUtil
*   3.AccountServiceImpl在调用dao层的时候使用传统方式，不符合ioc思想
* */
public class App {
    public static void main(String[] args) {

        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService accountService = ctx.getBean(AccountService.class);
        Account ac = accountService.findById(1);
        System.out.println(ac);
    }
}
