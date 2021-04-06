package com.kawainekosann.server.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//自定义错误的状态码
@ResponseStatus(value = HttpStatus.FORBIDDEN,reason = "自定义错误")
public class MyException extends RuntimeException{
    public MyException(String message){
        super(message);
    }
}
