package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.utils.SqlSessionUtil_quit;
import org.apache.ibatis.session.SqlSession;

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
//@Service("accountService")
//@Service
public class AccountServiceImpl implements AccountService {

    public void save(Account account) {
        SqlSession session = SqlSessionUtil_quit.getSession();
        /*
        * 接口类型 变量名 = 接口的实现类对象
        *   运行时创建实现类：动态代理 （底层：反射）
        * */
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.save(account);
        session.close();
    }

    public void update(Account account){
        SqlSession session = SqlSessionUtil_quit.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.update(account);
        session.close();
    }

    public void delete(Integer id) {
        SqlSession session = SqlSessionUtil_quit.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.delete(id);
        session.close();
    }

    public Account findById(Integer id) {
        SqlSession session = SqlSessionUtil_quit.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = accountDao.findById(id);
        session.close();
        return account;
    }

    public List<Account> findAll() {
        SqlSession session = SqlSessionUtil_quit.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAll();
        session.close();
        return list;
    }
}
