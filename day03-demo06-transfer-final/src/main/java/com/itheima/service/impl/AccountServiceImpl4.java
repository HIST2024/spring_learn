package com.itheima.service.impl;

import com.itheima.service.AccountService;
import com.itheima.service.AccountServiceClass;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/*
*               添加(声明式事务)
*                  a.让声明式事务生效@EnableTransactionManagement
*                  b.SpringConfig类 声明 DataSourceTransactionManager
*                  c.@Transactional放在切入点方法上
*
*       TODO：因为事务管理员和事物协调员不能再同一个bean中，所以传播行为不会生效！！！
*           注意：事务管理员和事物协调员要在不同的bean中
* */
@Service
public class AccountServiceImpl4 implements AccountService {

    @Autowired
    private AccountServiceClass asc;

    @Transactional
    //TODO S方法：事务管理员
    @Override
    public void transfer(int outId, int inId, double money) {
        //转账操作
        asc.s1(outId, inId, money);
        //记录日志
        asc.s2();
    }
}
