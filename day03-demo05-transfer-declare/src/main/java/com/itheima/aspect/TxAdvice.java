package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;

/**
 * @author codermao
 * @date 2023/2/22 17:40
 */
//@Component
//@Aspect
public class TxAdvice {
    @Autowired
    private DataSource dataSource;

    @Pointcut("execution(* com.itheima.service..*.transfer(..))")
    public void pt() {

    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint pjp) {
        Object result = null;
        //TODO：1.开启事务
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
               *        A事务：执行写
               *        B事务：不能读，不能写，如果能读就是脏读，
               *
               *        A事务：执行读
               *        B事务：可以执行读，不能写， 能写A就成脏读了
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
            //TODO:2.需要事务的业务方法
            result = pjp.proceed();
            //TODO : 3.1成功提交
            dstm.commit(ts);//成功,提交
        } catch (Throwable e) {
//            throw new RuntimeException(e);
            //TODO:3.2失败回滚
            dstm.rollback(ts);//失败,回滚
        }
        return result;
    }
}
