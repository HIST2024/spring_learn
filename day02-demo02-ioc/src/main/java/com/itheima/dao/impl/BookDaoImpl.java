package com.itheima.dao.impl;

import com.itheima.dao.BookDao;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/*
* 注解配置
*   @Repository("bookDao")相当于xml配置bean的id和class属性
*   1、添加bean到ioc容器中
*      @Component      @Controller    @Service    @Repository
*    组件(util、javabean) web           service     dao
*       @Scope("singleton")作用范围
*   生命周期
    *   @PostConstruct相当于init-method
    *   @PreDestory相当于destory-method
* */
@Repository("bookDao")
@Scope("singleton")
public class BookDaoImpl implements BookDao {
    @Override
    public void save() {
        System.out.println("BookDaoImpl run...");
    }

    @PostConstruct
    public void init(){
        System.out.println("BookDaoImpl init()....");
    }

    @PreDestroy
    public void destory(){
        System.out.println("BookDaoImpl desotry()...");
    }
}
