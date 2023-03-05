package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author codermao
 * @date 2023/2/23 19:46
 */
//定义表现层控制器bean(将当前bean放到ioc容器中)
@Controller
public class UserController {
    //设置映射路径为/save，即外部访问路径
    @RequestMapping("/save")
    //设置当前操作返回结果为字符串
    @ResponseBody
    public String save(){
        System.out.println("user save ...");
        return "hello";
    }
}