<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/8
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${msg}
<form action="http://localhost:8080/SpringMVC/register/hello" method="post">
    <input type="text" name="username"/>
    <input type="text" name="pwd"/>
    <input type="submit" value="提交">
</form>
</body>
</html>
