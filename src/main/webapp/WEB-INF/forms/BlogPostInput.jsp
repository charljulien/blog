<%--
  Created by IntelliJ IDEA.
  User: Mr. Black
  Date: 22/11/2018
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Blog</title>
    <style>
        <%@include file="/WEB-INF/css/home.css" %>
    </style>
</head>
<body>

<%@include file="../theBlog/fullPages/parts/header.jsp" %>
<form class="Blog-post" action="Post" method="POST">

    <input type="text" placeholder="title blog" name="title"
           style="float: left; background: lightgreen; border-radius: 5px;"><br>
    <textarea cols="50" rows="10" placeholder="text blog" name="postBlog"
              style="float: left; background: lightgreen; border-radius: 5px;"></textarea><br>

    <input type="submit" value="Submit Blog" style="float: left"><br>
</form>

</body>
</html>
