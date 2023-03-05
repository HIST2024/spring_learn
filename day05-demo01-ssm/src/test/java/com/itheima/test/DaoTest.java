package com.itheima.test;

import com.itheima.config.SpringConfig;
import com.itheima.dao.BookDao;
import com.itheima.domain.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author codermao
 * @date 2023/3/4 22:54
 */
@RunWith(SpringJUnit4ClassRunner.class)
/*
* 单元测试的话，Test方法就是入口
* */
@ContextConfiguration(classes = SpringConfig.class)
public class DaoTest {

    @Autowired
    BookDao dao;

    @Test
    public void method1(){
        //入口
        List<Book> list = dao.getAll();
        for (Book book : list) {
            System.out.println("book = " + book);
        }
    }
}
