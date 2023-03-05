package com.itheima.test;

import com.itheima.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author codermao
 * @date 2023/2/18 17:11
 */
/*
* 入门案例：
*   1.pom文件导入spring的坐标
*   2.编写接口+实现类   --> 实际业务,和框架无关
*   3.配置实现类(xml文件、注解)
*   4、从工厂中获取对象
*
*   代码解释：
*       1.创建工厂对象
*           BeanFactory 接口
*           ApplicationContext 子接口
    *           ClassPathXmlApplicationContext 实现类 (加载xml文件)
    *           AnnotationConfigApplicationContext 实现类 (加载注解配置：反射)
*       2.从工厂 中获取对象（从工厂的容器中获取对象）
*           1.IOC容器 IOC container
*           2.需要通过工厂才能访问容器
*
     * # 记录
     * 1. 快捷键
     *       1). ctrl + alt + u : 选中一个类, 查看这个类继承体系
* */
public class UserTest {
    @Test
    public void test01(){
        //2.加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        //3.获取资源: 通过配置文件中的id
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
    }
}
