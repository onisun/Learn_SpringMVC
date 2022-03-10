<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/9
  Time: 22:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome use</h1>${msg}<br><br>
    page : ${pageScope.msg}<br>
    request : ${requestScope.msg}<br>
    session : ${sessionScope.msg}<br>
    application : ${applicationScope.msg}<br>
    <hr>
    session : ${sessionScope.username}<br>
    request : ${requestScope.username}<br>

</body>
</html>
