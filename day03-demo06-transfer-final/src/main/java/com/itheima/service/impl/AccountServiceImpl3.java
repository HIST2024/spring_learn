package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;

/*
*               添加(声明式事务)
*                  a.让声明式事务生效@EnableTransactionManagement
*                  b.SpringConfig类 声明 DataSourceTransactionManager
*                  c.@Transactional放在切入点方法上
*
*       TODO：因为事务管理员和事物协调员不能再同一个bean中，所以传播行为不会生效！！！
* */
//@Service
public class AccountServiceImpl3 implements AccountService {
    @Autowired
    private AccountDao dao;
    //S方法：事务管理员
    @Override
    public void transfer(int outId, int inId, double money) {
        //转账操作
        s1(outId, inId, money);
        //记录日志
        s2();
    }
    private void s2(){
        dao.insertLog();
    }

    private void s1(int outId,int inId,double money){
        dao.outMoney(outId, money);

//        int i = 10 / 0;

        dao.inMoney(inId,money);
    }
}
