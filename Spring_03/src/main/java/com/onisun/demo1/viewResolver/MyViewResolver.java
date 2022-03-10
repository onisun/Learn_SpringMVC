package com.onisun.demo1.viewResolver;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

/**
 * @author Neo
 * @version 1.0
 */

public class MyViewResolver implements ViewResolver, Ordered {

    private int order = 0;

    public View resolveViewName(String viewName, Locale locale) throws Exception {
        if (viewName.startsWith("onisun:")) {
            String forwadrUrl = viewName.substring("onisun:".length());
            return new MyView();
        }
        return null;
    }

    public int getOrder() {
        return this.order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
