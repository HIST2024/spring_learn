package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author codermao
 * @date 2023/2/18 17:11
 */
/*
 * TODO:IOC配置
 * */
public class UserTest2 {
    /*
    *   set注入
    * */
    @Test
    public void test01() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService3");
        userService.save();
    }
}
