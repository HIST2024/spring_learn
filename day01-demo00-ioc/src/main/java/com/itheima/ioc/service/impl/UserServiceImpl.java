package com.itheima.ioc.service.impl;

import com.itheima.ioc.dao.UserDao;
import com.itheima.ioc.service.UserService;
import com.itheima.ioc.util.BeanFactory;
import org.junit.Test;

/**
* TODO:IOC思想
*
*  需求：service层要调用dao层 : 在service层中需要dao层对象
*   1、主动创建对象
 *      耦合严重：通俗解释就是当dao层需要变动，左右都要修改
*   2、面向接口编程(多态)
 *      好处：解耦：当dao层实现类变动，左边不需要修改
 *      缺点：右边还可能改变
*   3、反射 + 配置文件 ：
 *      好处： 进一步解耦 右边也不需要改变（直接修改配置文件，修改代码需要重新编译，修改配置文件不需要）
*   4、工厂模式 ：工厂用来创造商品，java中商品就是对象
 *      好处：封装创建对象方法，更好的管理对象
 *
*   IOC:inversion of control （控制反转）
*       控制：对象的控制权(创建、销毁)
*       反转：对象控制权由开发者转移到工厂中
*
*   框架：
 *      1）框架的事
     *      1、工厂类
     *      2、指定配置文件编写标准
 *      2）框架使用者做的事
     *      1、编写实现类
     *      2、进行配置
     *      3、用工厂获取对象
 *      例如：servlet、mybatis、…
 *
*/
public class UserServiceImpl implements UserService {

    @Test
    @Override
    public void add() throws Exception {
        //1. 主动创建对象
//        UserDaoImpl userDao = new UserDaoImpl();

        //2. 面向接口编程 : 解耦
//        UserDao userDao = new UserDaoImpl();

        //3. 反射 + 配置文件 : 进一步解耦
//        ResourceBundle bundle = ResourceBundle.getBundle("data");
//        String userDaoClassName = bundle.getString("userDao");

//        Class<?> clazz = Class.forName(userDaoClassName);
//        UserDao userDao = (UserDao) clazz.newInstance();

        //4. 工厂模式 : 统一管理bean的创建
        UserDao userDao = (UserDao) BeanFactory.getBean("userDao");
        userDao.addUser();
    }
}
