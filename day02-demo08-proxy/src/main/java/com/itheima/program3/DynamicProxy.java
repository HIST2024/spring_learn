package com.itheima.program3;

import com.itheima.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

//TODO: 这个类是伪代码,模拟JDK动态代理底层
public class DynamicProxy implements UserService {
    InvocationHandler h ;
    public DynamicProxy(InvocationHandler h){
        this.h = h;
    }
    @Override
    public void find() {
        try {
            Object proxy = this;
            Method method = this.getClass().getMethod("find");
            Object[] args = null;
            h.invoke(proxy,method,args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }


    public int save(String name,int age) {
        Integer result = null;
        try {
            Object proxy = this;
            Method method = this.getClass().getMethod("save",String.class,int.class);
            Object[] args = {name,age};
            result = (int) h.invoke(proxy,method,args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }
}
