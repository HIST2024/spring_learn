package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
/*
    TODO：spring整合mybatis
 * 最终版的spring和mybatis
     少了mybatis核心配置文件和mybatis工具类
 *   3.AccountServiceImpl在调用dao层的时候已经符合IOC思想
     多了啥：
        1.包spring-jdbc,mybatis-spring
        2.SpringConfig多了
           a.导入MyBatisConfig
           b.加载配置文件jdbc.properties
           c.连接池
       3.MyBatisConfig
            pojo别名包扫描
            接口包扫描
            对象的ioc管理
 * */
public class App {
    public static void main(String[] args) {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        //通过类型获取bean，要求此类型的bean在ioc中只有一个
        AccountService accountService = ctx.getBean(AccountService.class);
        Account ac = accountService.findById(1);
        System.out.println(ac);
    }
}
