package com.itheima.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author codermao
 * @date 2023/3/5 09:30
 */
/*
* TODO：异常处理器（AOP思想）
*   1.ControllerAdvice：默认controller层bean的所有方法为切入点
*   2.通知：异常通知
* */
//为Rest风格开发的控制器类做增强
//此注解自带@ResponseBody注解与@ControllerAdvice注解，具备对应的功能
//@ControllerAdvice注解：添加在异常处理器上
//@RestControllerAdvice
public class ProjectExceptionAdvice {
    /*
        专门处理Exception类型异常的通知
        1. 此方法在controller层代码抛出异常之后
        2. 并且此异常类型为Exception,那么此方法就会运行
        3. 而且参数ex就是所发生的异常
     */
    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        ex.printStackTrace();
        return new Result(666, "服务器繁忙，请稍后重试~~");
    }
}