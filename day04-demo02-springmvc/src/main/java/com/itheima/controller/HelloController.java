package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codermao
 * @date 2023/2/24 15:00
 */
/*
    编写位置
    @RequestMapping放在类上
*       窄化路径,访问此类中的方法时,必须加上类上的路径
    @RequestMapping放在方法上
        此方法的访问路径

    常用属性
        1. value或者path: 用来指定虚拟路径,value=可以省略
        2. method: 用来限定请求的方式   (restful风格)
            1). 不写,默认什么请求方式都可以
            2). 写了,指定了请求方式,如果不匹配就会响应405状态码(错误)
* */
@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @ResponseBody
    public String hello() {
        System.out.println("hello springmvc");
        return "Hello springmvc";
    }

    @RequestMapping("/delete")
    @ResponseBody
    public String delete() {
        System.out.println("user delete");
        return "user delete";
    }

}
