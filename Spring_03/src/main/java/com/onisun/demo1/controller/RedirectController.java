package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class RedirectController {

    @RequestMapping("redirect1")
    public String redirect1(){
        System.out.println("redirect01");
        return "redirect:/login.jsp";
    }

    @RequestMapping("redirect2")
    public String redirect2(){
        System.out.println("redirect02");
        return "redirect:/redirect1";
    }
}
