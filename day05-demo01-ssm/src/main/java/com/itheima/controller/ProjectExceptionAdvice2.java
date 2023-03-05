package com.itheima.controller;

import com.itheima.exception.BusinessException;
import com.itheima.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author codermao
 * @date 2023/3/5 09:30
 */
/*
* TODO：异常处理器（AOP思想）
*   1.ControllerAdvice：默认controller层bean的所有方法为切入点
*   2.通知：异常通知
* */
@RestControllerAdvice
public class ProjectExceptionAdvice2 {
    /*
        专门处理Exception类型异常的通知
        1. 此方法在controller层代码抛出异常之后
        2. 并且此异常类型为Exception,那么此方法就会运行
        3. 而且参数ex就是所发生的异常
     */
    @ExceptionHandler(BusinessException.class)
    public Result doException(BusinessException ex) {
        //发送对应消息给用户，提醒规范操作
        Integer code = ex.getCode();
        String message = ex.getMessage();

        return new Result(code, message);
    }

    @ExceptionHandler(SystemException.class)
    public Result doSystemException(SystemException ex) {
        //发送固定消息传递给用户，安抚用户
        Integer code = ex.getCode();
        String message = ex.getMessage();
        //发送特定消息给运维人员，提醒维护
        System.out.println("运维人员收到邮箱提醒");
        //记录日志
        System.out.println("记录日志");
        return new Result(code, message);
    }

    @ExceptionHandler(Exception.class)
    public Result doException(Exception ex) {
        //发送固定消息传递给用户，安抚用户
        //发送特定消息给编程人员，提醒维护
        String message = ex.getMessage();
        System.out.println("编程人员收到邮箱提醒");
        //记录日志
        System.out.println("记录日志");
        return new Result(Code.SYSTEM_UNKNOW_ERR, "服务器正在维护，请稍后重试");
    }
}