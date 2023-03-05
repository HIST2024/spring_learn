package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * TODO 事务设计：
 *   1.找到具备原子性的业务操作 ：转出 + 转入
 *   2.在这之前开始事务
 *   3.业务操作成功提交，失败回滚
 *
 * TODO 一、转账案例引入了事物
 *      1.问题：就是事物操作代码和业务操作代码耦合了，不利于扩展
 *          （如果还有事物需要事物，还需要再次编写事务代码）
 *      2.AOP
 *          1、AccountServiceImpl3：把AccountServiceImpl2中事务代码都删除了
 *          2、切面类 TxAdvice
*
 * */
@Service
public class AccountServiceImpl3 implements AccountService {
    @Autowired
    private AccountDao dao;

    /*
    * TODO：如果有异常通知，业务方法不能自己catch异常！！！
    *  1.方案一：不要try-catch
    *  2.方案二：可以try-catch，但是要在catch里面再抛出异常
    * */
    @Override
    public void transfer(int outId, int inId, double money) {
        //TODO：2.事物操作
        dao.outMoney(outId, money);
        //可能在转账过程中发生意外: 转出执行,转入还未执行
//        int i = 1 / 0;
        dao.inMoney(inId, money);

        /*try {
            //TODO：2.事物操作
            dao.outMoney(outId, money);
            //可能在转账过程中发生意外: 转出执行,转入还未执行
            int i = 1 / 0;
            dao.inMoney(inId, money);
        } catch (Exception e) {
//            e.printStackTrace();
//            throw e;
        }*/
    }
}
