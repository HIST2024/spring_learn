package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.domain.Account;
import com.itheima.service.AccountService;
import com.itheima.utils.SqlSessionUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AccountServiceImpl implements AccountService {

    public void save(Account account) {
        SqlSession session = SqlSessionUtil.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.save(account);
        session.close();
    }

    public void update(Account account){
        SqlSession session = SqlSessionUtil.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.update(account);
        session.close();
    }

    public void delete(Integer id) {
        SqlSession session = SqlSessionUtil.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        accountDao.delete(id);
        session.close();
    }

    public Account findById(Integer id) {
        SqlSession session = SqlSessionUtil.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        Account account = accountDao.findById(id);
        session.close();
        return account;
    }

    public List<Account> findAll() {
        SqlSession session = SqlSessionUtil.getSession();
        AccountDao accountDao = session.getMapper(AccountDao.class);
        List<Account> list = accountDao.findAll();
        session.close();
        return list;
    }
}
