package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/*
* TODO:
*   响应：
*       1.同步类型的响应
*           请求转发
*       2.异步类型的响应
*           普通字符串
*           json字符串
* */
@Controller
public class UserController4 {

    //这里的返回值是请求转发的地址
    @RequestMapping("/method01")
    public String method01(){
        System.out.println("method01");
        return "index.jsp"; //底层是请求转发 request.getRequestDispatcher("index.jsp").forward(request,reaponse);
    }

    @RequestMapping("/method02")
    //返回值会被放到响应体中，response.getWriter().print("method02");
    @ResponseBody
    public String method02(){
        System.out.println("method02");
        return "method02";
    }

    @RequestMapping("/method03")
    //会自动将pojo转换成json字符串:导入jackson，
    @ResponseBody
    public Object method03(){
        System.out.println("method03");
        User user = new User();
        user.setName("lisi");
        user.setAge(27);
        return user;
    }

}
