<!doctype html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${blogArticle.title}</title>
    <style>
        <%@include file="../../css/home.css"%>
    </style>
</head>

<body>
<%@include file="parts/header.jsp" %>
<fieldset class="blogArticleFieldset">
    <legend><h1 class="blogArticleLegendH1">Blog Article ${blogArticle.user.userName}</h1></legend>
    <div class="main">
        <div>
            <h2 class="blogArticleH2">Title: ${blogArticle.title}</h2>
            <p class="blogArticleP"> Blog Message: <br> ${blogArticle.blogMessage}</p>
            <h3 class="blogArticleH3">Likes: ${blogArticle.likeBlogCounter}</h3>

            <form id="like" action="Like" method="post">
                <input class="blogArticleInput" type="submit" value="Like" name="likeCounter">
                <input type="hidden" name="blogId" value="${blogArticle.id}">
            </form>
        </div>
    </div>
</fieldset>

<%@include file="parts/comment.jsp" %>

</body>
</html>
