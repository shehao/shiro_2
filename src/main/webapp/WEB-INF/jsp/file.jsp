<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/3
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="../../plugs/webuploader/webuploader.css">
    <script type="text/javascript" src="../../plugs/webuploader/webuploader.js"></script>
</head>
<body>
    <h2>first page</h2>
 <form method="post" action="${pageContext.request.contextPath}/file/upload" enctype="multipart/form-data">
     上传用户：<input type="text" name="username"><br/>
            上传文件1：<input type="file" name="file1"><br/>
            上传文件2：<input type="file" name="file2"><br/>
              <input type="submit" value="提交">
 </form>

</body>
</html>
