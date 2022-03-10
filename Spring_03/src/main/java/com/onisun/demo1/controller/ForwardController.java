package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class ForwardController {

    @RequestMapping("/forward1")
    public String forward1(){
        System.out.println("forward1");
        return "forward:/login.jsp";
    }


    @RequestMapping("/forward2")
    public String forward2(){
        System.out.println("forward2");
        return "forward:/forward1";
    }

    @RequestMapping("/forward3")
    public String forward3(){
        System.out.println("forward3");
        return "forward:/WEB-INF/jsp/success.jsp";
    }
}
