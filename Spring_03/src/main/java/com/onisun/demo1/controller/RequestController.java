package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class RequestController {

    @RequestMapping("/request")
    public String testRequest(@RequestParam("name") String name,Integer age){
        //不写@RequestParam 也能获取到参数
        System.out.println(name);
        System.out.println(age);
        return "success";
    }


    @RequestMapping("/head")
    public String header(@RequestHeader("User-Agent") String agent){
        //获取的是请求头中的User-Agent 信息
        System.out.println(agent);
        return "success";
    }

    @RequestMapping("/cookie")
    public String cookie(@CookieValue("JSESSIONID") String id){
        //获取的是cookie中的User-Agent 信息
        System.out.println(id);
        return "success";
    }
}
