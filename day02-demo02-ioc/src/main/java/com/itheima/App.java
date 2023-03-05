package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();

//        UserDao userDao = (UserDao) ctx.getBean("userDao");
//        userDao.save();

//        BookDao bookDao = (BookDao) ctx.getBean("bookDao");
//        bookDao.save();
    }
}
