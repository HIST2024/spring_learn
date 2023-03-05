package com.itheima.program1;

import com.itheima.service.impl.UserServiceImpl;

/*
*   方案一：继承
* */
public class UserServiceImplSon extends UserServiceImpl {

    @Override
    public void find() {
        System.out.println("1111");
        super.find();
        System.out.println("2222");
    }
}
