package com.kawainekosann.server;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * 启动类s
 */
//扫描指定路径里的webservlet
@ServletComponentScan("com.kawainekosann.server.servlet")
@PropertySource(value = "classpath:config/jdbc.properties")
@MapperScan("com.kawainekosann.server.dao")
//想要改变扫描路径，@SpringBootApplication(scanBasePackages="com.atguigu")
//或者@ComponentScan 指定扫描路径
@SpringBootApplication
public class YebApplication {
    public static void main(String[] args) {
        SpringApplication.run(YebApplication.class, args);
    }
}



