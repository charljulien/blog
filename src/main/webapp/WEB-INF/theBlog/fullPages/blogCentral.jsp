<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Blog Central</title>
    <link rel="stylesheet" href="../../css/home.css">
</head>

<body>
<div>
    <%@include file="parts/error.jsp" %>
</div>

<div class="header">
    <%@include file="parts/header.jsp" %>
</div>

<div>
    <fieldset class="blogCentralFieldset">
        <legend><h1 class="blogCentralH1">Blog Articles</h1></legend>
        <table class="blogCentralTable">
            <c:forEach items="${blogArticle}" var="blog" end="5" varStatus="status">
                <tr>
                    <td class="blogCentralTd"><a
                            href="${pageContext.request.contextPath}/Article?id=${blog.id}">${blog.title}</a></td>
                    <td class="blogCentralTdMessage">${blog.blogMessage}</td>
                    <td class="blogCentralTd" id="userName">${blog.user.userName}</td>
                    <td>
                        <form class="blogCentralForm" action="Like" method="post">
                            <input class="blogCentralInput" type="submit" value="Like" name="likeCounter">
                            <input type="hidden" name="blogId" value="${blog.id}">
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>