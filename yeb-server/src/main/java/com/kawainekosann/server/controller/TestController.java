package com.kawainekosann.server.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@CrossOrigin(origins = "*",maxAge = 3600)
public class TestController {

    //@CrossOrigin
    @RequestMapping("/test")
    public String test(){
        return "ok";
    }
}
