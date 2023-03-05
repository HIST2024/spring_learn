package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author codermao
 * @date 2023/3/4 22:20
 */
public class MyBatisConfig {

    /*
    * 将SqlSessionFactoryBean放到IOC容器
    *   1.dao层接口实现类对象都会被放到IOC容器中
    *       SqlSessionFactoryBean -》 SqlSessionFactory -》 SqlSession -》 dao层接口实现类对象
    *   2.这里需要连接池
    * */
    @Bean
    public SqlSessionFactoryBean sqlSessionFactory(DataSource dataSource){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setTypeAliasesPackage("com.itheima.domain");
        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //接口包扫描
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }
}