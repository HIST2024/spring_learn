package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.domain.Book;
import com.itheima.service.BookService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author codermao
 * @date 2023/3/4 23:14
        */
@RunWith(SpringJUnit4ClassRunner.class)
/*
 * 单元测试的话，Test方法就是入口
 * */
@ContextConfiguration(classes = SpringConfig.class)
public class ServiceTest {
    @Autowired
    BookService service;

    @Test
    public void method1(){
        List<Book> list = service.getAll();
        System.out.println(list);
    }
}
