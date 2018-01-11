<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/5
  Time: 10:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--需要使用shiro标签时应该先导入shiro标签库,类似jstl--%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>success</title>
</head>
<body>
    <h3>success page</h3>
    <shiro:hasRole name="admin">
    <a href="admin.jsp"> admin page</a>
    </shiro:hasRole>
    <br/>
    <shiro:hasRole name="user">
    <a href="user.jsp"> user page</a>
    </shiro:hasRole>
    <br/>
    <%--显示principal中的内容--%>
    welcome :<shiro:principal></shiro:principal>
    <br/>
    <a href="${pageContext.request.contextPath}/admin/testShiroAnnotation">TestShiroAnnotation</a>
</body>
</html>
