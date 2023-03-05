package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author codermao
 * @date 2023/2/21 20:12
 */
/*
        TODO：切面 = 切入点 + 通知
        指定切入点 : 指定com.itheima.service包下所有类的所有方法 (切入点表达式)
        1. @Pointcut配置切入点
        2. 需要写在一个三无方法上 (无参无返回值空方法体)

        1. 完整写法：execution(方法的修饰符 方法的返回值 类的全限定名.方法名(参数))
		        public void com.itheima.service.impl.AccountServiceImpl.insert(String)
        2. 支持通配符的写法：
            1) *   标识任意字符串
            2) ..  任意重复次数
        3. 规则
                1. 方法的修饰符可以省略：
                    execution(void com.itheima.service.impl.AccountServiceImpl.insert(String))
                2. 返回值可以使用*号代替：标识任意返回值类型
                   execution(* com.itheima.service.impl.AccountServiceImpl.insert(String))
                3. 包名可以使用*号代替，代表任意包（一层包使用一个*）
                    execution(* com.itheima.service.*.AccountServiceImpl.insert(String))
                4. 使用..配置包名，标识此包以及此包下的所有子包
                    execution(* com.itheima.service..AccountServiceImpl.insert(String))
                5. 类名可以使用*号代替，标识任意类         --> AccountServiceImpl和AccountServiceClass两个类都有insert方法
                    execution(* com.itheima.service..*.insert(String))
                6. 方法名可以使用*号代替，表示任意方法
                    execution(* com.itheima.service..*.*(String))
                7. 可以使用..配置参数，任意参数
                    execution(* com.itheima.service..*.*(..))
     */
//IOC配置: 当前bean需要加载到ioc容器中
@Component
//aop配置 : 声明当前类是切面类 (切面=切入点+通知)
@Aspect
public class MyAdvice {

//    @Pointcut("execution(* com.itheima.service.impl.AccountServiceImpl.*(..))")
    @Pointcut("execution(* com.itheima.service..*.*(..))")
    public void pt(){
    }

    /*@Before("pt()")
    public void before(){
        System.out.println("前置通知:11111111111111111");
    }

    @AfterReturning("pt()")
    public void afterReturning(){
        System.out.println("后置通知:2222222222222222");
    }

    @AfterThrowing("pt()")
    public void afterThrowing(){
        System.out.println("异常通知:3333333333333333333");
    }

    @After("pt()")
    public void after(){
        System.out.println("最终通知:44444444444444444444444");
    }*/
    /**
     * @param pjp 表示切入点(当前代理对象调用的方法)
    * */
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            System.out.println("11111111111");
            // Object result = method.invoke(目标对象,args);
            result = pjp.proceed();
            System.out.println("22222222222");
        } catch(Throwable throwable){
//        throwable.printStackTrace();
            System.out.println("33333333333");
        }finally {
            System.out.println("44444444444");
        }
        return result;
    }

}
