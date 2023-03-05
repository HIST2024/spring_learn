package com.itheima.service;

import com.itheima.dao.AccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author codermao
 * @date 2023/2/23 17:38
 */
@Service
public class AccountServiceClass {
    @Autowired
    private AccountDao dao;

    @Transactional(
            propagation = Propagation.NOT_SUPPORTED
    )
    public void s2(){
        dao.insertLog();
    }

    @Transactional(
            propagation = Propagation.REQUIRED
    )
    public void s1(int outId,int inId,double money){
        dao.outMoney(outId, money);

        dao.inMoney(inId,money);

        int i = 10 / 0;
    }
}
