package com.itheima.config;

import com.itheima.factory.MyBatisFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.itheima")
@Import(MyBatisFactory.class)
public class SpringConfig {
}
