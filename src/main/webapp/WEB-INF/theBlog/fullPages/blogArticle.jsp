<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="myscript.js"></script> <!-- ?????? -->


    <title>${all.title}</title>
</head>
<body>

<%@include file="parts/header.jsp" %>
<fieldset style="border-radius: 5px; margin:20px 50px"><legend><h1 style="text-align: center">Blog Article ${all.user.userName} </h1></legend>
<div class="main">
    <div>
        <h2 style="margin-left: 200px">Title: ${all.title} </h2>
        <p style="margin-left: 200px"> Blog Message: <br> ${all.blogMessage} </p>
        <h3 style="margin-left: 200px">Likes: ${all.likeBlogCounter} </h3> <!-- uploaded in real time -->

        <form id="like" action="Like" method="post">
            <input type="submit" value="Like" style="width: 50px;" name="likeCounter">
            <input type="hidden" name="blogName" value="${all.id}">
        </form>
    </div>
</div>
</fieldset>

<%@include file="parts/comment.jsp"%>

</body>
</html>
