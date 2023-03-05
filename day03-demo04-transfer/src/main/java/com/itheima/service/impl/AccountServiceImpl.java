package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

/*
* 事务设计：
*   1.找到具备原子性的业务操作 ：转出 + 转入
*   2.在这之前开始事务
*   3.业务操作成功提交，失败回滚
* */
//@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao dao;

    @Override
    public void transfer(int outId, int inId, double money) {
        try {
            dao.outMoney(outId, money);
            //可能在转账过程中发生意外: 转出执行,转入还未执行
            int i = 1/0;
            dao.inMoney(inId, money);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
