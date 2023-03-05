package com.itheima.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author codermao
 * @date 2023/3/5 16:03
 */
@RestController
@RequestMapping("books")
public class BookController {
    @GetMapping
    public Object get(){
        System.out.println("controller get执行了");
        return "get";
    }
}
