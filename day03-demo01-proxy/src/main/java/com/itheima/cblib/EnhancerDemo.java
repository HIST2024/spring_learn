package com.itheima.cblib;

import com.itheima.service.AccountServiceClass;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
    CGlib (Code Generation Library)
    0. 也是一个动态代理技术
    1. 不基于接口
        代理类有无父接口都可以
    2. 底层原理是继承
        代理类直接继承被代理类
    3. 动态: 代理类不是静态定义的, 是在运行过程中动态生成的

    Spring 的 AOP
    0. 思想: 不惊动原始设计前提下, 增强功能
    1. 被代理类有父接口, spring底层使用JDK Proxy
    2. 被代理类没有接口, spring底层使用 CGlib
    JDK8开始, JDK Proxy的效率高于CGlib

    CGlib
    1. 导包 : 第三方的库
    2. 编写api

 */
public class EnhancerDemo {

    public static void main(String[] args) {

        //1. 创建被代理类对象
        final AccountServiceClass asc = new AccountServiceClass();
        //2. 创建代理类对象
        //被代理类,也是代理类的父类
        Class<?> type = asc.getClass(); // AccountServiceClass.class
        Callback callback = new MethodInterceptor() {
            /*
                intercept(拦截): 代理类对象调用任何方法都执行此方法
                   1). proxy : 代理类对象 (没用)
                   2). method : 代理类对象当前调用的方法
                   3). args : 代理类对象当前调用方法传入的参数
                   4). methodProxy : 代理类对象当前调用的方法代理对象(不用)
                  return  : 代理类对象当前调用方法的返回值
             */
            @Override
            public Object intercept(Object proxy,
                                    Method method,
                                    Object[] args,
                                    MethodProxy methodProxy) throws Throwable {

                Object result = null;
                try {
                    System.out.println("11111111111");
                    result = method.invoke(asc, args);
                    System.out.println("222222222222");
                } catch (Exception e) {
                    System.out.println("333333333");
                } finally {
                    System.out.println("44444444444444");
                }
                return result;
            }
        };
        AccountServiceClass proxy =
                (AccountServiceClass) Enhancer.create(type, callback);

        //3. 调用代理类对象方法
        proxy.insert("一个用户");

//        B b = new B();
//        b.method01();
    }
}
/*
class A{
    final void method01(){

    }
}
class B extends A{

}*/
