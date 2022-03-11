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
  <form action="${ctx}/person">
    <input type="text" name="person" value="101-lucy-25-女"/>
    <input type="submit" value="自定义类型转换器"/>
  </form>
<br/>
  <form action="${ctx}/dateConvertion" method="post">
    编号：<input type="text" name="id"><br>
    姓名：<input type="text" name="name"><br>
    年龄：<input type="text" name="age"><br>
    性别：<input type="text" name="gender"><br>
    日期：<input type="text" name="birth"><br>
    <input type="submit" value="自定义日期格式转换器"/>
  </form>
  <br/><br/>
  <form action="${ctx}/dataValidate" method="post">
      编号：<input type="text" name="id">${errors.id}<br>
      姓名：<input type="text" name="name">${errors.name}<br>
      年龄：<input type="text" name="age">${errors.age}<br>
      性别：<input type="text" name="gender">${errors.gender}<br>
      日期：<input type="text" name="birth">${errors.birth}<br>
      邮箱：<input type="text" name="email">${errors.email}<br>
      <input type="submit" value="数据校验">
  </form>
  <img src="${ctx}/images/wallhaven-wyjvgx.jpg" height="100%" width="100%">
  </body>
</html>
