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
 * TODO：二、编程式事务的AOP改造
 *      1.分析spring的编程式事务
 *          1）。 编程式事务：就是通过编程写代码实现事务
 *          2）。API
 *              1.DataSourceTransactionManager ：事务管理器
 *                  支持mybatis框架，如果dao层用的是其它框架，有可能要切换成其他
 *              2.DefaultTransactionDefinition ：事务定义
 *                   a。隔离级别 事务隔离级别 一共四个，默认取值ISOLATION_DEFAULT
 *                   b。只读
 *                   c。超时
 *                   d.事务传播行为
 *              3.TransactionStatus
 *      2.问题：切面类TxAdvice代码冗余
 *          1.除了这些东西可能改变
 *              切入点、DataSourceTransactionManager、事务定义(4个常见属性)可能改变
 *          2.其他是不会改变的
 *          3.解决：Spring封装了TxAdvice类，后续使用事务，只需要声明就可以
 *              1).删除
 *                  a.SpringConfig类的@EnableAspectJAutoProxy去掉
 *                  b。TxAdvice类去掉
 *              2).添加(声明式事务)
 *                  a.让声明式事务生效@EnableTransactionManagement
 *                  b.SpringConfig类 声明 DataSourceTransactionManager
 *                  c.@Transactional放在切入点方法上
 *          4.声明式事务介绍：
 *                  a.声明式事务是spring关于事务场景基于aop再次封装
 *                  b.@Transactional位置
 *                      在类中方法上就表示这个方法是切入点
 *                      再类上，表示这个类所有方法都是切入点
 *                      在接口方法上，表示这个方法的所有实现类都是切入点 （常用！！）
 *                      在接口上，表示这个接口所有实现类方法都是切入点
 *   */
@Service
public class AccountServiceImpl3 implements AccountService {
    @Autowired
    private AccountDao dao;


    @Override
    public void transfer(int outId, int inId, double money) {
        //TODO：2.事物操作
        dao.outMoney(outId, money);
        //可能在转账过程中发生意外: 转出执行,转入还未执行
        int i = 1 / 0;
        dao.inMoney(inId, money);
    }
}
