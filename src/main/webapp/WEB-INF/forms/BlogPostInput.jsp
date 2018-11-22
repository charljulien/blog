<%--
  Created by IntelliJ IDEA.
  User: Computers Inc
  Date: 22/11/2018
  Time: 11:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Blog</title>
</head>
<body>
<!-- page to create a blog -->
<div class ="Blog-post-page">
    <form class="Blog-post" action="Post" method="POST">
        <input type="text" placeholder="title blog" name="title"><br>
        <textarea cols="50" rows="10" placeholder="text blog" name="postBlog"></textarea>
        <input type="submit" value="Submit Blog">
    </form>
</div>
</body>
</html>
