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
* TODO：AOP入门案例
*    1.aop的jar包：aspectjweaver
*    2。SpringConfig要开启一个注解 @EnableAspectJAutoProxy
*    3.切面类 = 切入点 + 通知
*
*   相关概念：
*       目标对象 代理对象 连接点 切入点 通知（前置、后置、异常、最终、环绕） 织入
* */
//spring整合junit
@RunWith(SpringJUnit4ClassRunner.class)
//加载注解配置类
@ContextConfiguration(classes = SpringConfig.class)
public class MyApp {
    //从ioc中取出来的是代理对象
    @Autowired
    AccountService service;
//    AccountServiceClass service;
    @Test
    public void test01(){
//        System.out.println(service);
        System.out.println(service.getClass());
        //配置对insert方法具有增强效果
        service.insert("参数");
    }
}