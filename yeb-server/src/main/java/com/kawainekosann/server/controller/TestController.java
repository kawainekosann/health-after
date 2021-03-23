package com.kawainekosann.server.controller;

import com.kawainekosann.server.pojo.TestYaml;
import com.kawainekosann.server.pojo.TestYaml2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
