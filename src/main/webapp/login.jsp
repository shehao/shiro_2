<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/2
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
</head>
<body>
    <h1>login page</h1>
    <form action="${pageContext.request.contextPath}/admin/checkLogin" method="post">
        账号:<input type="text" name="username" value=""/>
        <br/>
        密码:<input type="password" name="password" value=""/>
        <br/>
        <input type="submit" value="提交"/>

    </form>
</body>
</html>
