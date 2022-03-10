package com.onisun.demo1.viewResolver;

import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Neo
 * @version 1.0
 */
public class MyView implements View {
    public String getContentType() {
        return "text/html";
    }

    public void render(Map<String, ?> map, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("保存的对象是：" + map);
        response.setContentType("text/html");
        String msg = (String) map.get("msg");
        response.getWriter().write(msg);
    }
}
