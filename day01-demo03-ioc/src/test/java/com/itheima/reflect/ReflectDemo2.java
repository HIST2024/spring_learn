package com.itheima.reflect;

import com.itheima.dao.UserDao;
import com.itheima.dao.impl.UserDaoImpl;

import java.lang.reflect.Method;

/*
    TODO: Java的生命周期
    1. 生命周期
      SOURCE(源码)    COMPILE(编译)     RUNTIME(运行时)
      xx.java         xx.class        xx.class(Class对象)
                编译器
                                类加载器
                                            垃圾回收器
   2. jvm中的几个组件
        1). 编译器(java compiler) : 将xx.java源码编译成xx.class字节码文件
              I. 编译看左边,运行看右边
              II. 编译器在编译阶段工作,不知道运行时阶段的事
        2). 类加载器(classloader): 将xx.class字节码文件加载到内存,JVM会根据此文件创建对象的Class对象
              I. Class对象:开发者无法创建的,只能获取
              II. Class对象三种获取方式
        3). 垃圾回收器 (garbage collector) : 在运行时回收堆中无用的对象
              I. 对象是存在堆中的,GC有自己的回收算法的

   TODO: 反射的操作

         类中有啥，反射就可以操作啥
            属性、方法、构造器、注解(自定义Junit)、…

 */
public class ReflectDemo2 {

    public static void main(String[] args) throws Exception {

        UserDao dao = new UserDaoImpl();
//        dao.show();
        Class<?> clazz = dao.getClass();
        Object o = clazz.newInstance();
        Method show = clazz.getMethod("show");
        show.invoke(o);

        //赋值是运行时的操作
        /*boolean result = true;
        while(result){
            System.out.println("xxxx");
        }

        while(true){
            System.out.println("yyyy");
        }
        System.out.println();*/
    }
}
