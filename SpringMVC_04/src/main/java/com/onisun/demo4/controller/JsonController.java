package com.onisun.demo4.controller;

import com.onisun.demo4.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class JsonController {

    @ResponseBody
    @RequestMapping("/json")
    public List<User> json(){
        List<User> list = new ArrayList<User>();
        list.add(new User(1,"lucy",15,"女"));
        list.add(new User(2,"nancy",16,"女"));
        list.add(new User(3,"jack",17,"男"));
        list.add(new User(4,"bob",19,"男"));

        return list;
    }

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body){
        System.out.println(body);
        return "success";
    }
}
