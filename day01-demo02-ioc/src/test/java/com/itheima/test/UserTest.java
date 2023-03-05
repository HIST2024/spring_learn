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
 * TODO:IOC配置
 * */
public class UserTest {
    @Test
    public void test01() {
        //2.加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
//        ApplicationContext ctx = new AnnotationConfigApplicationContext();
        //3.获取资源: 通过配置文件中的id
        UserService userService = (UserService) ctx.getBean("userService");
        userService.save();
//        ClassPathXmlApplicationContext cpxac = (ClassPathXmlApplicationContext) ctx;
//        cpxac.close();
    }
    /*
    * 工厂配置
    * */
    @Test
    public void test02() {
        //2.加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取资源: 通过配置文件中的id
        UserService userService = (UserService) ctx.getBean("userService2");
        userService.save();

    }

    //测试scope属性
    @Test
    public void test03() {
        //2.加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //3.获取资源: 通过配置文件中的id
        UserService userService = (UserService) ctx.getBean("userService");
//        System.out.println("userService = " + userService);
        UserService userService2 = (UserService) ctx.getBean("userService");
//        System.out.println("userService2 = " + userService2);

        //理论上方法执行结束，工厂就会销毁，IOC容器中的对象也跟着销毁，然后destory方法执行，但是
        //由于jvm关闭太快，来不及打印就造成destory方法好像没执行
        //这里手动调用close方法，提前销毁工厂那么就可以看到destory方法的内容打印了
        ClassPathXmlApplicationContext cpxac = (ClassPathXmlApplicationContext) ctx;
        cpxac.close();
    }


}
