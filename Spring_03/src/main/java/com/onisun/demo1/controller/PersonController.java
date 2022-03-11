package com.onisun.demo1.controller;

import com.onisun.demo1.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class PersonController {

    @RequestMapping("/person")
    public String addPerson(Person person, Model model){
        System.out.println(person);
        model.addAttribute("person",person);
        return "success";
    }

    @RequestMapping("/dateConvertion")
    public String dateConvertion(Person person, Model model){
        System.out.println(person);
        model.addAttribute("person",person);
        return "success";
    }
}
