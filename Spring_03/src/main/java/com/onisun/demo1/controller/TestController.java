package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/test1")
    public void test(){
        System.out.println("test。。。。");
    }
}
