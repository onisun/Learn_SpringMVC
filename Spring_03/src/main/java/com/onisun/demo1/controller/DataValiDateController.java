package com.onisun.demo1.controller;

import com.onisun.demo1.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class DataValiDateController {

    @RequestMapping("/dataValidate")
    public String dataValiDate(@Valid Person person,BindingResult bindingResult,Model model){

        System.out.println(person);
        Map<String,Object> map = new HashMap<String, Object>();
        if (bindingResult.hasErrors()){
            System.out.println("登陆失败");
            //获取到所有的错误
            List<FieldError> fieldErrors = bindingResult.getFieldErrors();
            for (FieldError fieldError : fieldErrors) {
                System.out.println(fieldError.getField());
                System.out.println(fieldError.getDefaultMessage());
                //给前端取值
                map.put(fieldError.getField(),fieldError.getDefaultMessage());
            }
            model.addAttribute("errors",map);
            return "forward:/index.jsp";
        }else {
            System.out.println("登陆成功");
            return "success";
        }
    }
}
