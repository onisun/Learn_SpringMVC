package com.onisun.demo4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/test")
    public String test(){
        System.out.println("test。。。。。。。。。。。。");
        return "redirect:/index.jsp";
    }

    @ResponseBody
    @RequestMapping("/test2")
    public String test2(){
        System.out.println("test2...........");
        return "<h1>Success</h1>";
    }


}
