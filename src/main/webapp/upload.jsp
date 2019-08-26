<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/17
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<form method="post"action="/user/upload" enctype="multipart/form-data">
    <input type="file" name="files" multiple id="file">
    <input type="submit"/>
</form>
</body>
</html>
