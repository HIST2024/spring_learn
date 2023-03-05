package com.itheima.test;

import com.itheima.factory.StaticFactory;
import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserTest {

    @Test
    public void method01(){
        //1. 创建工厂
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 从工厂的ioc容器中获取bean
            // getBean方法返回Object,是因为spring无法预测ioc容器的bean的类型
//        UserService userService = (UserService) ctx.getBean("userService");
//        UserService userService2 = (UserService) ctx.getBean("userService");
//        userService.save();

//        System.out.println(userService);
//        System.out.println(userService2);


        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService");
        //其实, 程序执行结束, 会默认销毁工厂和ioc容器,但是如果是销毁, jvm会迅速关闭, bean的close方法来不及打印
        //所以,我们手动调用close方法,提前销毁工厂,让jvm预留足够时间让bean的close方法打印
        ctx.close();
    }


    @Test
    public void method02(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) ctx.getBean("userService8");
        userService.save();
    }
}
