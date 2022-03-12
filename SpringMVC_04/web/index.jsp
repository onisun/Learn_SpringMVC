<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/12
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <%
    pageContext.setAttribute("ctp",request.getContextPath());
  %>
  <body>
  <form action="${ctp}/testRequestBody" method="post">
    <input name="username" value="zhangsan"><br>
    <input name="password" value="123456"><br>
    <input type="file" name="file" ><br>
    <input type="submit"><br>
  </form>

<hr>
  <form action="${ctp}/upload" method="post" enctype="multipart/form-data">
    描述: <input type="text" name="desc"/><br><br>
    文件: <input type="file" name="file"/><br><br>
    <input type="submit" value="提交"/>
  </form>
  </body>
</html>
