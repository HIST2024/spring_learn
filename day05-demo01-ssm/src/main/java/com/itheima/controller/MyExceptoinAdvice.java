package com.itheima.controller;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author codermao
 * @date 2023/3/5 09:33
 */
/*
* -- 切面 = 切入点 + 通知
			-- 切入点: controller层所有方法
			-- 通知: 异常通知
* */
//@Component
//@Aspect
public class MyExceptoinAdvice {
    @Pointcut("execution(* com.itheima.controller..*.*(..))")
    public void pt(){
        
    }
    
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            result = pjp.proceed();
        }catch (NullPointerException e){
            System.out.println("这里处理空指针异常");
            method01(e);
        }catch (Exception e){
            System.out.println("这里处理除Exception异常（除空指针异常）");
            method02(e);
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }
        return result;
    }

    private void method02(Exception e) {
    }

    private void method01(NullPointerException e) {
    }
}
