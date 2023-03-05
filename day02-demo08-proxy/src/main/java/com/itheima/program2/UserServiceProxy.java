package com.itheima.program2;

import com.itheima.service.UserService;

/*
        方案二: 装饰模式 (代理模式)
        1). 角色
             I. 父接口/父类 : UserService
                    被代理类和代理类拥有相同父接口或父类
             II. 被代理类 : UserServiceImpl
             III. 代理类 : UserServiceProxy
                  a. 内部维护一个被代理类的对象
                  b. 代理类的方法是对被代理类同名方法的增强
                  c. 调用逻辑: 使用者 -> 代理类的find方法 -> 基于被代理类的find方法进行增强
        2). 套路
             I. 创建被代理类的对象
             II. 创建代理类的对象
             III. 调用代理类对象的方法
        3). 跟继承对比
             I. 继承只能增强父类
             II. 而装饰模式可以增强所有UserService实现类 (扩展性更强)
* */
public class UserServiceProxy implements UserService {

    //被代理类对象
    private UserService userService;

    public UserServiceProxy(UserService userService){
        this.userService = userService;
    }
    @Override
    public void find() {
        System.out.println("1111111");
        userService.find();
        System.out.println("2222222");
    }
}
