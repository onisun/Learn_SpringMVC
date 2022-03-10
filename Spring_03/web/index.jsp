<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/9
  Time: 21:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ASR</title>
  </head>
  <%
    pageContext.setAttribute("ctx",request.getContextPath());
  %>
  <body>
  Access Static Resources 
  <img src="${ctx}/images/wallhaven-wyjvgx.jpg" height="100%" width="100%">
  </body>
</html>
