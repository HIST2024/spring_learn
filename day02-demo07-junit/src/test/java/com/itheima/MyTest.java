package com.itheima;

import com.itheima.config.SpringConfig;
import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

/**
 * @author codermao
 * @date 2023/2/20 19:57
 */
/*
* 原生junit
*   问题：代码冗余
* */
public class MyTest {
    @Test
    public void mehod01(){
        //spring加载配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountService service = ctx.getBean(AccountService.class);
        List<Account> list = service.findAll();
        for (Account account : list) {
            System.out.println("account = " + account);
        }
    }

    @Test
    public void method2(){
        //spring加载配置
        ApplicationContext ctx = new AnnotationConfigApplicationContext(SpringConfig.class);
        AccountDao dao = ctx.getBean(AccountDao.class);
        Account account = dao.findById(1);
        System.out.println("account = " + account);
    }
}
