package com.itheima.factory;

import com.itheima.dao.AccountDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author codermao
 * @date 2023/2/20 17:08
 */
/*
* SqlSessionFactoryBuilder -> SqlSessionFactory -> SqlSession -> AccountDao(最重要)
* */
//@Component
public class MyBatisFactory {
    //将SqlSessionFactoryBuilder放到ioc容器中
    @Bean
    public static SqlSessionFactoryBuilder getBuilder(){
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        return builder;
    }

    //@Bean方法的参数列表中声明某个对象，此变量会自动从IOC容器中获取
    @Bean
    public static SqlSessionFactory getFactory(SqlSessionFactoryBuilder builder) throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = builder.build(inputStream);
        return factory;
    }

    @Bean
    public static SqlSession getSession(SqlSessionFactory factory) throws IOException {
        SqlSession sqlSession = factory.openSession(true);
        return sqlSession;
    }

    @Bean
    public static AccountDao getDao(SqlSession session) throws IOException {
        AccountDao mapper = session.getMapper(AccountDao.class);
        return mapper;
    }
}
