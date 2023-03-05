package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codermao
 * @date 2023/2/24 17:30
 */
/*
 * TODO:restful的快速开发
 *  @RestController = @Controller + @ResponseBody
 *      @Controller：添加bean到IOC容器中
 *      @ResponseBody：返回值会被放到响应体中
 *
 * rest风格mapping
 *  @GetMapping
 *  @PostMapping
 *  @DeleteMapping
 *  @PutMapping
 * */
//@Controller
//@ResponseBody
@RestController
@RequestMapping(value = "/rest", produces = "text/html;charset=utf-8")
public class RestController2 {
    /*
     * 前端请求地址：http://localhost:8080/rest
     * */
//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String getAll() {
        System.out.println("get:查询全部");
        return "get:查询全部";
    }

    /*
     * 前端请求地址：http://localhost:8080/rest/3
     * 后端：@RequestMapping(value = "/rest/{id} ---》 RequestMapping中value的{id} = 3
     *      @PathVariable Integer id
     * */
//    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @GetMapping(value = "/{id}")
    public String getById(@PathVariable Integer id) {
        System.out.println("get:查询 " + id);
        return "get:查询" + id;
    }

    //    @RequestMapping(value = "/{page}/{size}", method = RequestMethod.GET)
    @GetMapping(value = "/{page}/{size}")
    public String getById(@PathVariable Integer page, @PathVariable Integer size) {
        System.out.println("get:查询 " + page + "," + size);
        return "get:查询 " + page + "," + size;
    }

    //    @RequestMapping(method = RequestMethod.POST)
    @PostMapping
    public String post(@RequestBody User user) {
        System.out.println("post:新增" + user);
        return "post:新增" + user;
    }

    //    @RequestMapping(method = RequestMethod.PUT)
    @PutMapping
    public String put(@RequestBody User user) {
        System.out.println("put:修改" + user);
        return "put:修改" + user;
    }

    //    @RequestMapping(method = RequestMethod.DELETE)
    @DeleteMapping
    public String delete() {
        System.out.println("delete:删除");
        return "delete:删除";
    }

    //    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @DeleteMapping(value = "/{id}")
    public String deleteById(@PathVariable Integer id) {
        System.out.println("delete:删除 " + id);
        return "delete:删除" + id;
    }
}
