package com.itheima;

import com.itheima.program1.UserServiceImplSon;
import com.itheima.program2.UserServiceProxy;
import com.itheima.service.UserService;
import com.itheima.service.impl.UserServiceImpl;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
    TODO:
        需求 : 在不影响原始设计的前提下, 增强UserServiceImpl的find方法
        1). 增强UserServiceImpl的find方法:
                记录此方法的运行时机,以便后续性能调优
        2). 在不影响原始设计的前提下: 避免耦合,不会产生代码冗余

    TODO: 方案一: 继承
        1): 增强父类

    TODO: 方案二: 装饰模式 (代理模式)
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

     TODO: 方案三: 动态代理
        1). 动态
            代理类不是源码阶段静态定义的,是在运行阶段动态生成 (反射)
        2). 代理
        3). 跟装饰进行对比
            I. 假设接口有100个方法都需要增强,装饰要写增强代码100次
            II. 如果是动态代理, 增强代码一次就够了

        反射: 运行时操作类
            反射可以对相同规律的代码进行抽取

 */
public class TestDemo {
    //动态代理
    @Test
    public void method03() throws Exception {
        //1. 创建被代理类的对象
        UserServiceImpl userService = new UserServiceImpl();
        //2. 创建代理类的对象
        /*
            Proxy.newProxyInstance(loader,interfaces,h); 底层
            1. 创建一个类(字节码),实现interfaces (动态字节码)
            2. 这个字节码接着会被loader加载,产生Class对象
            3. h的invoke方法会被这个代理类的所有方法调用
         */
            //类加载器: 加载.class文件,产生Class对象
        ClassLoader loader = userService.getClass().getClassLoader();
            //获取userService这个类实现所有接口
        Class<?>[] interfaces = userService.getClass().getInterfaces();
//        Class<?>[] interfaces = {UserService.class};

        InvocationHandler h = new InvocationHandler() {
            /*
             * 代理类对象调用任何方法都将执行invoke
             * 1. proxy : 代理类对象本身
             * 2. method : 代理类对象当前调用的方法
             * 3. args : 代理类对象当前调用的方法传入的参数
             * 返回值 : 代理类对象当前调用的方法产生的返回值
             * */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("1111111111");
                //当 proxy.find();的时候, 这一行等价于userService.find()
                Object result = method.invoke(userService, args);
                System.out.println("222222222");
                return result;
            }
        };

        UserService proxy = (UserService) Proxy.newProxyInstance(loader, interfaces, h);
        //3. 调用代理类对象的方法
        proxy.find();
    }

    //装饰模式
    @Test
    public void method02() throws Exception {
        //1. 创建被代理类的对象
        UserServiceImpl userService = new UserServiceImpl();
        //2. 创建代理类的对象
        UserServiceProxy proxy = new UserServiceProxy(userService);
        //3. 调用代理类对象的方法
        proxy.find();

//        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.txt"));
//        bis.read();
    }

    //继承
    @Test
    public void method01() {
        UserServiceImplSon son = new UserServiceImplSon();
        son.find();
    }
}
