package com.onisun.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class ParvariableController {

    @RequestMapping("/login/{page}")
    public String login(@PathVariable String page) {
        //访问地址：http://localhost:8080/SpringMVC/login/hahaha
        //此时@PathVariable 获取的page值是:hahaha
        //RequestMapping的值和PathVariable的参数不一致，可以使用@PathVariable("xxx")
        //如 :@RequestMapping("/login/{page}")   login(@PathVariable("page") String name)
        System.out.println(page);
        return "hello";
    }
}
