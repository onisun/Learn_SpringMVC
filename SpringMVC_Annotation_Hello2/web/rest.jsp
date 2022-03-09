<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/9
  Time: 20:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Title</title>
</head>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
<form action="${ctp}/user" method="post">
    <input type="submit" value="增加">
</form>

<form action="${ctp}/user/1" method="post">
    <input name="_method" value="delete" type="hidden">
    <input type="submit" value="删除">
</form>

<form action="${ctp}/user/1" method="post">
    <input name="_method" value="put" type="hidden">
    <input type="submit" value="修改">
</form>

<a href="${ctp}/user/1">查询</a><br/>
</body>
</html>
