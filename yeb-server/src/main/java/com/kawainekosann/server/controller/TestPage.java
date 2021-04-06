package com.kawainekosann.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestPage {
    @RequestMapping("/haha")
    public String page(Model model){
        model.addAttribute("msg","hhahaha");
        model.addAttribute("link","www.baidu.com");

        return  "success";
    }

}
