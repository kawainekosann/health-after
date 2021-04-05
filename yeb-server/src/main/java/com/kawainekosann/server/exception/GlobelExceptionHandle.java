package com.kawainekosann.server.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 处理整个web的controller异常
 */
@Slf4j
@ControllerAdvice
public class GlobelExceptionHandle {
    //处理异常的类型数组
    @ExceptionHandler({ArithmeticException.class,NullPointerException.class})
    //此处可以返回modelandview也可以返回string直接跳转视图
    public String handlerArithException(Exception e){
    log.error("异常是{}",e);
    return "login";
    }
}
