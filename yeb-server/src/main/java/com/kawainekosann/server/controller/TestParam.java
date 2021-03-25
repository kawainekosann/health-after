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

}
