package com.itheima.factory;

import com.itheima.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author codermao
 * @date 2023/2/20 11:28
 */
/*
* 工厂方式配置
*   缺点：配置麻烦
*   优点：
*   1、无需类名
*   2、第三方的类无法用注解方式配置(第三方框架的类都是字节码，无法直接编写)
*       第三方的类可以用xml配置，无法使用注解配置
*
* 配置：
*   1.当前类要被spring找到 -> @Component
*   2.在工厂方法上添加@Bean
*   效果：此方法返回值会被放到IOC中
* */
//@Component
public class StaticFactory {
    @Bean("us")
    public static Object getObject(){
        return new UserService() {
            @Override
            public void save() {
                System.out.println("StaticFactory UserService save()...");
            }
        };
    }

    public static Object getCtx(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        return ctx;
    }
}
