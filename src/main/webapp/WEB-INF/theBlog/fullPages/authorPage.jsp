<!-- url for this page is: localhost:8080/theblog/author -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="myscript.js"></script>
    <style>
        <%@include file="/WEB-INF/css/home.css" %>
    </style>
</head>
<body>
<div>
    <%@include file="parts/header.jsp" %>
</div>

<!-- include body author page with the articles of said author -->
<div>
    <table>
        <p>The blogs are here...?</p>
        <c:forEach items="${blogPostByUser}" var="blog" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${blog.title}</td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>