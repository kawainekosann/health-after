package com.kawainekosann.server.controller;

import com.kawainekosann.server.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestException {
    @RequestMapping("/exception")
    public String exception(){
        if(true){
            throw new MyException("自定义错误");
        }
        return "success";
    }
}
