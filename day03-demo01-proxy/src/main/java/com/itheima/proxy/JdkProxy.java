package com.itheima.proxy;

import com.itheima.service.AccountService;
import com.itheima.service.impl.AccountServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    代理模式
    1. 创建被代理类对象
    2. 创建代理类对象
         增强了被代理类对象的功能
    3. 调用代理类对象的方法
        底层往往调用了被代理类对象的方法

 TODO   JDK Proxy:
        代理类和被代理类拥有相同的父接口!
        代理类必须基于接口的
 */
public class JdkProxy {

    public static void main(String[] args) {

        //1. 创建被代理类对象
        final AccountServiceImpl service = new AccountServiceImpl();

        //2. 创建代理类对象
//        ClassLoader loader = service.getClass().getClassLoader();
//        Class<?>[] interfaces = service.getClass().getInterfaces();
        ClassLoader loader = JdkProxy.class.getClassLoader(); // 应用类加载器: 加载第三方类 (类加载器)
        Class<?>[] interfaces = {AccountService.class};
        InvocationHandler h = new InvocationHandler() {
            /*
                invoke方法 : 代理类对象调用任意方法,都会执行此方法
                   1). proxy : 代理类对象 (没用)
                   2). method : 代理类对象当前调用的方法
                   3). args : 代理类对象当前调用方法传入的参数
                  return  : 代理类对象当前调用方法的返回值
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                try {
                    System.out.println("11111111111111");
                    //service.insert("一个用户");
                    result = method.invoke(service, args);
                    System.out.println("22222222222222");
                } catch (Exception e) {
                    System.out.println("33333333333333");
                } finally {
                    System.out.println("444444444444444");
                }
                return result;
            }
        };
        AccountService proxy =
                (AccountService) Proxy.newProxyInstance(loader, interfaces, h);

        //3. 调用代理类对象的方法
        proxy.insert("一个用户");
    }
}
