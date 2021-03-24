package com.kawainekosann.server.controller;

import com.kawainekosann.server.pojo.TestYaml;
import com.kawainekosann.server.pojo.TestYaml2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Configuration(proxyBeanMethods = false)
//proxyBeanMethodstrue 使用代理，直接从IOC容器之中取得对象；如果设置为false,也就是不使用注解，每次调用@Bean标注的方法获取到的对象和IOC容器中的都不一样，是一个新的对象，所以我们可以将此属性设置为false来提高性能

//@Import({User.class, DBHelper.class})
//给容器中自动创建出这两个类型的组件、默认组件的名字就是全类名
@RestController
//用ConstructorBinding 必须启用EnableConfigurationProperties
@EnableConfigurationProperties(TestYaml.class)
//@CrossOrigin(origins = "*",maxAge = 3600)
public class TestController {
    @Autowired
    private TestYaml testYaml;

    //@CrossOrigin
    @RequestMapping("/test")
    public String test() {
        //return "ok";
        return testYaml.toString();
    }

    @Bean
    @ConfigurationProperties(prefix = "yaml2.level")
    public TestYaml2 AgetTestYaml2(){
        return new TestYaml2();
    }

    @Autowired
    private TestYaml2 testYaml2;

    @RequestMapping("/test2")
    public String test2() {
        return testYaml2.toString();
    }
}
