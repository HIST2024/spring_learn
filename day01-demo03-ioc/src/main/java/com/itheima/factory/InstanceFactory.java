package com.itheima.factory;

import com.itheima.service.UserService;

/*
    工厂的作用: 创建对象
 */
public class InstanceFactory {

    public Object getObject(){
        System.out.println("yy");
        //这是一个匿名内部类,只知道此类是UserService接口的实现类,但不知道类名
        UserService userService = new UserService() {
            @Override
            public void save() {
                System.out.println("userService的匿名内部类的save方法222...");
            }
        };
        return userService;
    }
}
