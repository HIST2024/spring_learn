package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
* service层需要dao层，dao层对象没有再ioc容器中
*    TODO：spring + mybatis ioc改造
*
*   1.mybatis使用过程中设计到的对象
*       SqlSessionFactoryBuilder -> SqlSessionFactory -> SqlSession -> AccountDao(最重要)
*   2.ioc改造
*       a.将这些对象放到ioc容器中
*           1.方案一：在这些类上加@Component、…    （行不通，这些类有第三方类只有字节码和动态代理类）
*           2.工厂模式：
*               @Bean
*
* */
@Service
//@Service
public class AccountServiceImpl2 implements AccountService {
    //从ioc容器中获取对象
    @Autowired
    AccountDao accountDao;

    public void save(Account account) {
        accountDao.save(account);

    }

    public void update(Account account){
        accountDao.update(account);
    }

    public void delete(Integer id) {
        accountDao.delete(id);
    }

    public Account findById(Integer id) {
        Account account = accountDao.findById(id);
        return account;
    }

    public List<Account> findAll() {
        List<Account> list = accountDao.findAll();
        return list;
    }
}
