package com.itheima.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author codermao
 * @date 2023/3/4 22:31
 */
@Configuration
// springmvc的ioc容器只管理web层相关的bean
@ComponentScan({"com.itheima.controller","com.itheima.config"})
//支持json自动转换, 日期转换等
@EnableWebMvc
public class SpringMvcConfig {
}
