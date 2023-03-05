package com.itheima.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

/**
 * @author codermao
 * @date 2023/2/20 17:42
 */
/*
*    替代了MyBatisFactory_quit和mybatis核心配置文件
* */
public class MybatisConfig {
    /*
    * SqlSessionFactoryBean会创建SqlSessionFactory
    * SqlSessionFactoryBean -> SqlSessionFactory -> SqlSession -> dao的bean
    * */
    @Bean
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource ds){
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        //设置pojo的包扫描
        factoryBean.setTypeAliasesPackage("com.itheima.domain");
        //设置连接池
        factoryBean.setDataSource(ds);

        return factoryBean;
    }
    //定义bean，返回MapperScannerConfigurer对象(mybatis的spring整合包提供的类)
    @Bean
    public MapperScannerConfigurer mapperScannerConfigurer(){
        MapperScannerConfigurer msc = new MapperScannerConfigurer();
        //设置dao层的接口扫描
        msc.setBasePackage("com.itheima.dao");
        return msc;
    }
}
