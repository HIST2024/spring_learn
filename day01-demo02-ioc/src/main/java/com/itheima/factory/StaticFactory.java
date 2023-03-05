package com.itheima.factory;

import com.itheima.service.UserService;

/**
 * @author codermao
 * @date 2023/2/18 20:44
 * descripe:工厂的作用：用代码来创建类(不需要知道类名)
 */
public class StaticFactory {
    public static Object getBean(){
        return new UserService(){
            @Override
            public void save(){
                System.out.println("匿名内部类 StaticFactory UserService save()...");
            }
        };
    }
}
