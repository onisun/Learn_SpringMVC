package com.onisun.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
@RequestMapping("/register")
public class HelloController {

    //必须是POST请求 而且必须有username和pwd两个参数
    @RequestMapping(value = "/hello",method = RequestMethod.POST,params = {"username","pwd"})
    public String hello(Model model){
        model.addAttribute("msg","this my first annotation based SpringMVC");
        return "hello";
    }

}
