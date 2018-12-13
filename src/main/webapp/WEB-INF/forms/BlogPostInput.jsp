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
<form class="blogPostForm" action="Post" method="POST">

    <input class="blogPostTitle" type="text" placeholder="title blog" name="title"><br>
    <textarea class="blogPostTextArea" cols="50" rows="10" placeholder="text blog" name="postBlog"></textarea><br>
    <input class="blogPostInput" type="submit" value="Submit Blog"><br>
</form>

</body>
</html>
