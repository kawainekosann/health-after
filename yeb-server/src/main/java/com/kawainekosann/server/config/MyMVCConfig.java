package com.kawainekosann.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

@Configuration
//@EnableWebMvc 想定制化不能引入该注解
//如果你想diy一些定制化的功能 只要写这个组件 然后将他放到bean里就行，springboot会自动装配
public class MyMVCConfig implements WebMvcConfigurer {
    //ViewResolver 实现了视图解析器的类，我们就可以把他看成视图解析器
    @Bean
    public MyViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    public static class MyViewResolver implements ViewResolver{
        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInceptor()).addPathPatterns("/**").excludePathPatterns("/","login");
    }

    //视图跳转
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/kuang").setViewName("success");
    }
}
