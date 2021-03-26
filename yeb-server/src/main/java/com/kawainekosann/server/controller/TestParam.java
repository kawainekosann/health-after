package com.kawainekosann.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
public class TestParam {
    final Logger logger = LoggerFactory.getLogger(getClass());

    // car/2/owner/liu
    @GetMapping("car/{id}/owner/{username}?age=13&intrests")
    public Map<String, Object> getcar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String, String> vp,
                                      @RequestHeader("User-Agent") String UserAgent,
                                      @RequestHeader Map<String, String> headers,
                                      @RequestParam("age") Integer age,
                                      //获取request attribute的内容
                                      //@RequestAttribute("msg") String msg,
                                      //@CookieValue("ga") String ga,
                                      //@CookieValue("ga") Cookie cookie
                                      //@RequestParam("intrests")List<String> intrest ,
                                      @RequestParam Map<String, String> params) {
        Map<String, Object> map = new HashMap<>();
//        map.put("id", id);
//        map.put("username", username);
//        map.put("vp", vp);
//        map.put("User-Agent", UserAgent);
//        map.put("headers", headers);
        map.put("age", age);
        //map.put("intrests", intrest);
        map.put("params", params);
        return map;
    }

    @PostMapping("/save")
    public Map postMethod(@RequestBody String content){
        Map<String,Object> map = new HashMap<>();
        map.put("content",content);
        return map;
    }

    //1、语法： 请求路径：/cars/sell;low=34;brand=byd,audi,yd
    //2、SpringBoot默认是禁用了矩阵变量的功能
    //      手动开启：原理。对于路径的处理。UrlPathHelper进行解析。
    //              removeSemicolonContent（移除分号内容）支持矩阵变量的
    //3、矩阵变量必须有url路径变量才能被解析
    @GetMapping("/cars/{path}")
    public Map carsSell(@MatrixVariable("low") Integer low,
                        @MatrixVariable("brand") List<String> brand,
                        @PathVariable("path") String path){
        Map<String,Object> map = new HashMap<>();

        map.put("low",low);
        map.put("brand",brand);
        map.put("path",path);
        return map;
    }


    // /boss/1;age=20/2;age=10

    @GetMapping("/boss/{bossId}/{empId}")
    public Map boss(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                    @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String,Object> map = new HashMap<>();

        map.put("bossAge",bossAge);
        map.put("empAge",empAge);
        return map;

    }
}
