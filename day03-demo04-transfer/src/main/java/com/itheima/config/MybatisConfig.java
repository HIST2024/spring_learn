package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;



public class MybatisConfig {

    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource ds){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置pojo的包扫描
        factoryBean.setTypeAliasesPackage("com.itheima.pojo");
        //设置连接池
        factoryBean.setDataSource(ds);

        return factoryBean;
    }

    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //设置dao层的接口扫描
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }

}
