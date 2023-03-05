package com.itheima.service.impl;

import com.itheima.dao.UserDao;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
/*
* TODO：属性注入
*   1.@Value:基本数据类型和String
*       不需要set方法，无需关心类型转化
*   2.@Autowired：自动装配
*       a.适用于除String外的其他引用类型
*       b。自动装配：自动从ioc容器中获取bean
*           1.自动配置， 如果IOC容器中只有一个此类型的对象,会自动配置
*           2.如果IOC容器中有多个此类型的对象,会自动配置跟变量名一致的标识的bean
*           3。如果IOC容器中有多个此类型的对象,且跟变量都不一致，需要手动设置@Qualifier
*
* TODO:加载properties配置文件
*   @PropertySource 加载外部配置文件
*   spring el表达式
*       写到spring外面是没有效果的，没有解析
*
* */
@Service("userService")
@PropertySource("classpath:jdbc.properties")
public class UserServiceImpl implements UserService {
//    @Value("jdbc:mysql://localhost:3306/db")
    @Value("${jdbc.url}")
    private String url;

//    @Value("com.mysql.jdbc.Driver")
    @Value("${jdbc.driver}")
    private String driver;
    @Value("18")
    private Integer age;
    @Autowired
    @Qualifier("userDao2")
    private UserDao userDao3;
    @Override
    public void save() {
        System.out.println("UserServiceImpl run...");
        System.out.println(url);
        System.out.println(driver);
        System.out.println(age);
        userDao3.save();
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public void setDao(UserDao dao) {
        this.userDao3 = dao;
    }
}
