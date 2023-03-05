package com.itheima.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
/*
* TODO：
*   在SpringMvc中，webapp目录下的资源是默认不能访问的！
*   1.原理：
*       前端请求地址：http://localhost:8080/pages/books.html
*       后端：tomcat -> DispatcherServlet(拦截所有请求路径，是Spring封装的) —>
*           会去找DispatcherServlet会去找它知道的路径
*           1.com.itheima.controller下面的内容
*           2.SpringMvcSupport 配置的静态资源路径（没有配置，访问会404）
*    2.非重点的两个原因
*       1.以后要用，直接复制
*       2.前后端分离的背景下，这个技术点是用不到的
* */
@Configuration
public class SpringMvcSupport extends WebMvcConfigurationSupport {
    //设置静态资源访问过滤，当前类需要设置为配置类，并被扫描加载
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        //当访问/pages/????时候，从/pages目录下查找内容
        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
    }
}
