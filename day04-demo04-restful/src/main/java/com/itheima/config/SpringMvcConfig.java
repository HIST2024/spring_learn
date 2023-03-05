package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author codermao
 * @date 2023/2/24 14:59
 */
//springmvc配置类，本质上还是一个spring配置类
@Configuration
@ComponentScan("com.itheima.controller")
/*
* 开启json数据类型自动转换
* @EnableWebMvc注解功能十分强大，json只是其中一个
* */
@EnableWebMvc
public class SpringMvcConfig {
}