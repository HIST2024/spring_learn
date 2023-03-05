package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author codermao
 * @date 2023/2/21 20:11
 */
//配置类
@Configuration
//包扫描
@ComponentScan("com.itheima")
// 开启aop注解支持 TODO
@EnableAspectJAutoProxy
public class SpringConfig {

}