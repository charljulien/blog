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

<fieldset style="border-radius: 5px; margin:20px 50px">
    <legend><h2 style="text-align: center">${userBean.userName}'s Blog Articles</h2></legend>
    <table style="margin: 50px 150px 50px 100px">
        <c:forEach items="${author}" var="blog" varStatus="status">
            <tr>
                <td style="font-weight: bold">${blog.title}</td>
                <td style="font-weight: lighter">${blog.blogMessage}</td>
            </tr>
        </c:forEach>
    </table>
</fieldset>
</body>
</html>