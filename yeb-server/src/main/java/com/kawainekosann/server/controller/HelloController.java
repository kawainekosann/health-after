package com.kawainekosann.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

//需要模板引擎支持 thymleaf
@Controller
public class HelloController {

    @RequestMapping("/a")
    public String index(Model model){
        model.addAttribute("msg","<h1>hello</h1>");
        model.addAttribute("users", Arrays.asList("liu1","liu2"));
        return "index";
    }
}
