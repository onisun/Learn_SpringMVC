package com.onisun.demo1.controller;

import com.onisun.demo1.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/addUser")
    public String addUser(User user){
        System.out.println(user);
        return "success";
    }
}
