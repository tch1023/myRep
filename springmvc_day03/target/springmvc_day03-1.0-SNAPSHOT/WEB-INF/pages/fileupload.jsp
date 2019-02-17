<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/14
  Time: 上午 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/user/fileUpLoad" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br>
    <input type="submit" value="上传">
</form>

<form action="/user/fileUpLoad1" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br>
    <input type="submit" value="springmvc上传">
</form>

<form action="/user/fileUpLoad2" method="post" enctype="multipart/form-data">
    <input type="file" name="upload"><br>
    <input type="submit" value="跨服务器上传">
</form>
</body>
</html>
