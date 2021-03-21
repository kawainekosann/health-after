package com.kawainekosann.server.controller;

import com.alibaba.fastjson.JSON;
import com.kawainekosann.server.dao.UserDao;
import com.kawainekosann.server.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {
    @Autowired
    UserDao userDao;

    @RequestMapping("/login")
    public String login(@RequestBody User user) {
        String flag = "error";
        System.out.println(user);
        User result = userDao.getUserByMsg(user);
        HashMap<String,Object> res = new HashMap<String,Object>();
        if(result!=null){
            flag="ok";
        }
        res.put("flag",flag);
        res.put("user",result);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }
}
