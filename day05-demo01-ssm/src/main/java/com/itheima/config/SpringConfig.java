package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author codermao
 * @date 2023/3/4 21:46
 */
//声明Spring配置类（添加到IOC容器中）
@Configuration
/*
 * TODO:Spring管理除web层之外的其他bean（web层的bean由SpringMVC管理）
 *  1.方案一：扫描的包一个个添加，除了web层
 *  2.方案二：先选中全部，然后排除web层
 *      1.会扫描com.itheima下所有的类
 *      2.不解析Controller和RestConstroller注解 = 排除web层的bean
 *
 * */
@ComponentScan({"com.itheima.service","com.itheima.dao"})
//@ComponentScan(value = "com.itheima", excludeFilters = @ComponentScan.Filter(value = {Controller.class, RestController.class}))
@PropertySource("classpath:jdbc.properties")
//dao层的bean就会放到IOC容器中
@Import({JdbcConfig.class,MyBatisConfig.class})
@EnableTransactionManagement
public class SpringConfig {
}
