<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>AuthorPage</title>
    <style>
        <%@include file="/WEB-INF/css/home.css" %>
    </style>
</head>
<body>
<div>
    <%@include file="parts/header.jsp" %>
</div>

<fieldset class="authorPageFieldset">
    <legend><h2 class="authorPageH2">${userBean.userName}'s Blog Articles</h2></legend>
    <table class="authorPageTable">
        <c:forEach items="${author}" var="blog" varStatus="status">
            <tr>
                <td class="authorPageTdOne">${blog.title}</td>
                <td class="authorPageTdTwo">${blog.blogMessage}</td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>