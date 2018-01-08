<%@ page isELIgnored="false" %><%-- 如果设定为真，那么JSP中的表达式被当成字符串处理。比如下面这个表达式＜p＞${2000 % 20}＜/p＞在isELIgnored＝"true"时输出为${2000 % 20}，而isELIgnored＝"false"时输出为100。Web容器默认isELIgnored＝"false"。 --%>
<%@ page trimDirectiveWhitespaces="true" %><!-- 这个命令可以使jsp输出的html时去除多余的空行（jsp上使用EL和tag会产生大量的空格和空行）。但是这个命令是从JSP2.1规范以后才得到支持。所以在tomcat 6.0之前的版本上如果使用这个命令就会抛出异常：Page directive has invalid attribute: trimDirectiveWhitespaces -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- <fmt:setBundle basename="resources.messages" var="messagesBundle"/> --%><!--资源绑定  -->
<c:set var="base" value="${pageContext.request.scheme}://${pageContext.request.serverName}:${pageContext.request.serverPort}${pageContext.request.contextPath}/" />
<%--静态文件目录 --%>
<c:set var="path" value="${base}" /><%-- ${path} --%>
<%--项目路径 --%>
<c:set var="baseurl" value="${base}" /><!--${baseurl}  -->