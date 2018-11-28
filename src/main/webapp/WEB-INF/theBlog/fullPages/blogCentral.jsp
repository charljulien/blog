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
    <fieldset style="border-radius: 5px; margin:20px 50px">
        <legend><h1 style="text-align: center">Blog Articles</h1></legend>
        <table style="margin-left: 100px; margin-right: 150px">
            <c:forEach items="${all}" var="blog" end="5" varStatus="status">
                <tr>
                    <td><a href="${pageContext.request.contextPath}/Article?id=${blog.id}"> ${blog.title} </a></td>
                    <td>${blog.blogMessage}</td>
                    <td>${blog.user.userName}</td>
                    <!-- like count field -->
                    <td>
                        <form style="margin-left: 10px; margin-top: 25px" action="Like" method="post">
                            <input type="submit" value="Like" style="width: 50px;" name="likeCounter">
                            <input type="hidden" name="blogName" value="${blog.id}">
                        </form>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </fieldset

</div>

</body>
</html>