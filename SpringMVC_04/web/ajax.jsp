<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2022/3/12
  Time: 19:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="script/jquery-1.9.1.min.js"></script>
</head>
<%
    pageContext.setAttribute("ctp",request.getContextPath());
%>
<body>
<a href="${ctp}/json" >获取用户信息</a>
<div>

</div>
<script type="text/javascript">
    $("a:first").click(function () {
        $.ajax({
            url:"${ctp}/json",
            type:"GET",
            success:function (data) {
                console.log(data)
                var user = this.id+"--"+this.name+"--"+this.age+"--"+this.gender+"--"+this.birth+"--"+this.email;
                $("div").append(user+'<br/>');
            }
        });
        return false;
    });
</script>
</body>
</html>
