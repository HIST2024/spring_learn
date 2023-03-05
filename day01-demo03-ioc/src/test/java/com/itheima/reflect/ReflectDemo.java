package com.itheima.reflect;

/*
    TODO:

        反射: 运行时操作类
        1. 运行时
            1). java的生命周期
                SOURCE(原码)      COMPILE(编译)     RUNTIME(运行时)
                xx.java             xx.class       xx.class(Class对象)
            2). 运行时的类: Class对象
       2.  操作 : 类中有啥, 反射就可以操作啥
            1). 属性
            2). 方法
            3). 构造器
            4). 注解  (回顾: 自定义junitTest)
            ...
       3. 思考反射技术:
            1). 一般情况,我们都是在源码阶段操作类,而且更为便捷
            2). 框架技术底层会用到反射
                I. 因为框架在编写的时候,很多代码是不存在的(源码没有),所以无法常规编写代码
                II. 但是这些代码运行时会有(开发者会配置,框架去读取),所以就用反射


 */
public class ReflectDemo {

    public static void main(String[] args) throws Exception {
        //源码阶段操作类
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.save();
        //静态跟对象无关
//        UserServiceImpl userService = null;
//        userService.show();

        //运行阶段操作类
//        Class<?> clazz = Class.forName("com.itheima.service.impl.UserServiceImpl");
//        Object object =  clazz.newInstance();
//        Method show = clazz.getMethod("show");
//        show.invoke(null);


    }
}
