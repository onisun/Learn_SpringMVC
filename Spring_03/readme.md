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



