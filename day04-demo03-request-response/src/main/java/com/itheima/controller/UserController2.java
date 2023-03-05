package com.itheima.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author codermao
 * @date 2023/2/24 15:44
 */
/*
* TODO:特殊情况
*   1. 前端请求参数和后端参数名不一样
*           @RequestParam("name") String username
*   2. 请求参数包含中文
*       1.tomcat8 get请求乱码解决了，post没有
*       2.过滤器
*           在ServletContainersInitConfig配置类中进行配置即可
*   3.日期处理
*       前端传递的日期数据对后端来说就是字符串，如果需要转换成Date型
*       解决：@DateTimeFormat(pattern = "yyyy-MM-dd") Date birth
* */
@Controller
public class UserController2 {
    //普通参数：请求参数与形参名称对应即可完成参数传递
    @RequestMapping("/commonParam3")
    @ResponseBody
    public String commonParam(@RequestParam("name") String username , int age){
        System.out.println("普通参数传递 name ==> "+username);
        System.out.println("普通参数传递 age ==> "+age);
        return "hello";
    }

    @RequestMapping("/dateParam")
    @ResponseBody
    public String commonParam(String birth) throws ParseException {
        System.out.println("普通参数传递 birth ==> "+birth);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = sdf.parse(birth);
        System.out.println(parse);
        return "birth";
    }

    @RequestMapping("/dateParam2")
    @ResponseBody
    public String commonParam(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birth){
        System.out.println("普通参数传递 birth ==> "+birth);
        return "birth";
    }

}
