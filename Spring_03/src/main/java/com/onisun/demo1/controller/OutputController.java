package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 使用Model，Map，ModelMap ModelAndView传输数据到页面
 * 发现都是将数据放到了request作用域中
 * 如何将数据放到session中？ 要使用 @SessionAttributes注解
 * @author Neo
 * @version 1.0
 */
@Controller
@SessionAttributes("msg") //表示将msg放到session作用域中
public class OutputController {

    @RequestMapping("/output1")
    public String output1(Model model){
        model.addAttribute("msg","output1 model ");
        System.out.println(model.getClass());
        return "output";
    }

    @RequestMapping("/output2")

    public String output1(ModelMap model){
        model.addAttribute("msg","output2 ModelMap ");
        return "output";
    }

    @RequestMapping("/output3")
    public String output1(Map map){
        map.put("msg","output3 Map ");
        return "output";
    }

    @RequestMapping("/output4")
    public ModelAndView output4(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("output");
        mv.addObject("msg","output4  ModelAndView");
        return mv;
    }
}
