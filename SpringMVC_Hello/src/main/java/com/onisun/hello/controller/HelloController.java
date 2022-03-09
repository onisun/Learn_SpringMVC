package com.onisun.hello.controller;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author Neo
 * @version 1.0
 */
public class HelloController implements Controller {

    public ModelAndView handleRequest(javax.servlet.http.HttpServletRequest httpServletRequest, javax.servlet.http.HttpServletResponse httpServletResponse) throws Exception {
        ModelAndView view = new ModelAndView();
        view.setViewName("hello");
        view.addObject("msg","Hello SpringMVC .......");
        return view;
    }
}
