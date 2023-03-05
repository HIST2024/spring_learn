package com.itheima.service.impl;

import com.itheima.dao.AccountDao;
import com.itheima.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

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
 * */
//@Service
public class AccountServiceImpl2 implements AccountService {
    @Autowired
    private AccountDao dao;
    //开启事物需要连接池
    @Autowired
    private DataSource dataSource;

    @Override
    public void transfer(int outId, int inId, double money) {
        //TODO：1.这里开启事物
        //1. 创建事务管理器
        DataSourceTransactionManager dstm = new DataSourceTransactionManager();
        //为事务管理器设置与数据层相同的数据源!!!
        dstm.setDataSource(dataSource);
        //2. 创建事务定义对象 : 隔离级别/传播特性/超时时间...
        DefaultTransactionDefinition td = new DefaultTransactionDefinition();
          /*
                设置事务隔离级别
                    0). spring默认隔离级别是跟数据库软件一致 (ISOLATION_DEFAULT)
                    1). mysql默认是REPEATABLE_READ
                    2). oracle默认是READ_COMMITTED
             */
        td.setIsolationLevel(TransactionDefinition.ISOLATION_DEFAULT);
            /*
            *   设置是否为只读事务
            *      1). false,表示读写均可(默认设置,适合增删改操作)
                   2). true,表示只读(适合查,效率高)
            * */
        td.setReadOnly(false);
        /*
         *   设置超时时间
         *      1). 默认值是-1, 表示永不超时
         *      2). 单位是秒
         * */
        td.setTimeout(10);
            /*
                设置事务传播行为
                    1. 一般增删改：REQUIRED (默认值)
                    2. 一般查询  SUPPORTS
                    这个比较复杂,待会详解
            * */
        td.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
        //3.创建事务状态对象，用于控制事务执行(了解)  -> 相当于开启事务
        TransactionStatus ts = dstm.getTransaction(td);
        try {
            //TODO：2.事物操作
            dao.outMoney(outId, money);
            //可能在转账过程中发生意外: 转出执行,转入还未执行
//            int i = 1 / 0;
            dao.inMoney(inId, money);
            //TODO：3.1提交成功
            dstm.commit(ts);//成功,提交
        } catch (Exception e) {
            e.printStackTrace();
            //TODO:3.2提交失败
            dstm.rollback(ts);//失败,回滚
        }
    }

    public void transfer2(int outId, int inId, double money) {

    }
}
