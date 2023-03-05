package com.itheima.config;

import com.itheima.factory.StaticFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author codermao
 * @date 2023/2/20 16:27
 */
/*
* @Configuration 一般用在配置类上将当前bean放到ioc容器中
* */
@Configuration
//组件扫描
@ComponentScan("com.itheima")
@Import(StaticFactory.class)
public class SpringConfig {
    /*@Bean("us")
    public static Object getObject(){
        return new UserService() {
            @Override
            public void save() {
                System.out.println("StaticFactory UserService save()...");
            }
        };
    }*/
}
