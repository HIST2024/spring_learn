package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author codermao
 * @date 2023/2/23 19:44
 */
//springmvc配置类，本质上还是一个spring配置类
@Configuration
//组件扫描/包扫描：让spring能找到这个包下所有的类（注解才能生效）
@ComponentScan("com.itheima.controller")
public class SpringMvcConfig {
}