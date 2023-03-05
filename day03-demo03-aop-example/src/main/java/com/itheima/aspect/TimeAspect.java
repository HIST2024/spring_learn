package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author codermao
 * @date 2023/2/21 21:52
 */
//@Component
//@Aspect     //切面 = 切入点 + 通知
public class TimeAspect {
    //切入点是service下的所有以find开头的方法
    @Pointcut("execution(* com.itheima.service..*find*(..))")
    public void pt(){
    }

    //通知
    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp){
        Object result = null;
        try {
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < 10000; i++) {
                result = pjp.proceed();
            }
            long endTime = System.currentTimeMillis();
            //获得当前执行方法的方法名
            Signature methodName = pjp.getSignature();
            System.out.println(methodName + "耗时:" + (endTime - startTime));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
        return result;
    }
}
