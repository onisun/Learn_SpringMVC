### SpringMVC中对请求参数的处理

@RequestParam : 获取请求参数

@RequestHeader : 获取请求头信息

@CookieValue : 获取cookie中的信息



```java
@RequestMapping("/request")
public String testRequest(@RequestParam("name") String name,Integer age){
    //不写@RequestParam 也能获取到参数
    System.out.println(name);
    System.out.println(age);
    return "success";
}

@RequestMapping("/head")
public String header(@RequestHeader("User-Agent") String agent){
    //获取的是请求头中的User-Agent 信息
    System.out.println(agent);
    return "success";
}

@RequestMapping("/cookie")
public String cookie(@CookieValue("JSESSIONID") String id){
    //获取的是cookie中的User-Agent 信息
    System.out.println(id);
    return "success";
}
```



### SpringMVC中处理乱码的Filter

```xml
    <filter>
        <filter-name>characterEncodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>

<!--        解决post请求乱码-->
        <init-param>
            <param-name>encoding</param-name>
            <param-value>UTF-8</param-value>
        </init-param>
<!--        解决get请求乱码-->
        <init-param>
            <param-name>forceEncoding</param-name>
            <param-value>true</param-value>
        </init-param>
    </filter>
```



### 使用Model，Map，ModelMap, ModelAndView传输数据到页面

#### 使用@sessionAttributes注解将数据放到session中

```java
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
```



### 使用forward实现页面转发

```java
package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class ForwardController {

    @RequestMapping("/forward1")
    public String forward1(){
        System.out.println("forward1");
        return "forward:/login.jsp";
    }


    @RequestMapping("/forward2")
    public String forward2(){
        System.out.println("forward2");
        return "forward:/forward1";
    }

    @RequestMapping("/forward3")
    public String forward3(){
        System.out.println("forward3");
        return "forward:/WEB-INF/jsp/success.jsp";
    }
}
```



### 使用redirect来实现重定向

```java
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
```

### 请求转发和重定向的区别

​		请求转发特点如下：

​		1、地址栏的请求不会发生变化，显示的还是第一次请求的地址

​		2、请求的次数，有且仅有一次请求

​		3、请求域中的数据不会丢失

​		4、根目录：localhost:8080/项目地址/,包含了项目的访问地址



重定向：

​		在浏览器端进行页面的跳转，需要发送两次请求（第一次是人为的，第二次是自动的）

​		特点如下：

​		1、地址栏的地址发生变化，显示最新发送请求的地址

​		2、请求次数：2次

​		3、请求域中的数据会丢失，因为是不同的请求

​		4、根目录：localhost:8080/  不包含项目的名称



### 静态资源的访问

因为DispatcherServlet会拦截所有请求会导致静态资源访问不了，在applicationContext中配置即可

```xml
<!--    配置这个后可以访问静态资源，但是会访问不了其他请求 -->
    <mvc:default-servlet-handler/>
<!--    静态资源和动态请求都能访问-->
    <mvc:annotation-driven/>
```



### 自定义视图解析器



```java
package com.onisun.demo1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Neo
 * @version 1.0
 */
@Controller
public class MyViewController {

    @RequestMapping("/myview")
    public String myView(Model model){
        model.addAttribute("msg","msg from MyViewController");
        return "onisun:/myView.html";
    }
}
```



```java
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

    //设置排序 执行优先
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
```



```java
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
        //这里的map已经存了msg信息
        System.out.println("保存的对象是：" + map);
        response.setContentType("text/html");
        String msg = (String) map.get("msg");
        response.getWriter().write(msg);
    }
}
```



```xml
<!--    自定义视图解析器-->
    <bean id="myViewResolver" class="com.onisun.demo1.viewResolver.MyViewResolver">
<!--        设置执行优先-->
        <property name="order" value="1"/>
    </bean>
```





### 自定义类型转换器

定义一个类实现Converter接口，来实现自定义类型转换

```java
package com.onisun.demo1.converter;

import com.onisun.demo1.bean.Person;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author Neo
 * @version 1.0
 */
@Component
public class MyConverter implements Converter<String, Person> {

    public Person convert(String source) {
        Person person = null;
        String[] split = source.split("-");
        if (source != null && split.length == 4){
            person = new Person();
            person.setId(Integer.parseInt(split[0]));
            person.setName(split[1]);
            person.setAge(Integer.parseInt(split[2]));
            person.setGender(split[3]);
            System.out.println("convert-----"+person);
        }
            return person;
    }
}
```



在applicationContext.xml中配置这个类

```xml
    <bean id="conversionService" class="org.springframework.context.support.ConversionServiceFactoryBean">
<!--        自定义类型转换-->
        <property name="converters">
            <set>
                <ref bean="myConverter"/>
            </set>
        </property>
    </bean>
```

表单

```jsp
<form action="${ctx}/dateConvertion" method="post">
  编号：<input type="text" name="id"><br>
  姓名：<input type="text" name="name"><br>
  年龄：<input type="text" name="age"><br>
  性别：<input type="text" name="gender"><br>
  日期：<input type="text" name="birth"><br>
  <input type="submit" value="自定义日期格式转换器"/>
</form>
```



```java
@RequestMapping("/dateConvertion")
public String dateConvertion(Person person, Model model){
    System.out.println(person);
    model.addAttribute("person",person);
    return "success";
}
```



### 后端数据校验

![image-20220311230549562](image/image-20220311230549562.png)



![image-20220311230601076](image/image-20220311230601076.png)

引入pom依赖

```xml
<dependency>
    <groupId>org.hibernate</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>5.1.0.Final</version>
</dependency>
```



使用注解

```java
package com.onisun.demo1.bean;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author Neo
 * @version 1.0
 */
public class Person {
    private Integer id;
    @NotNull
    @Length(min = 5,max = 10)
    private String name;
    private Integer age;
    @Length(max = 2)
    private String gender;
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    @Email
    private String email;
}
```



使用@Valid

```java
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
```



```jsp
<form action="${ctx}/dataValidate" method="post">
    编号：<input type="text" name="id">${errors.id}<br>
    姓名：<input type="text" name="name">${errors.name}<br>
    年龄：<input type="text" name="age">${errors.age}<br>
    性别：<input type="text" name="gender">${errors.gender}<br>
    日期：<input type="text" name="birth">${errors.birth}<br>
    邮箱：<input type="text" name="email">${errors.email}<br>
    <input type="submit" value="数据校验">
</form>
```
