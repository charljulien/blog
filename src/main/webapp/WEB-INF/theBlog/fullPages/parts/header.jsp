<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="myscript.js"></script>
    <style>
        <%@include file="../../../css/home.css" %>
    </style>
    <title>HeaderPage</title>
</head>


<body>
<c:if test="${not empty userBean}">
    <div class="topnav" id="topnavLogout">
        <ul>
            <li><a href="./Home"> Home </a></li>
            <li><a href="./UserProfile"> My Profile </a></li>
            <li>
                <form action="Post" method="post"><a href="Post"> Create Blog</a></form>
            </li>

            <form class="logoutForm" action="Logout" method="get">
                <li><input class="logoutInput" type="submit" value="Logout">
                    <p class="active"> Welcome ${userBean.userName}</p></li>
            </form>
        </ul>
    </div>
</c:if>


<!-- condition else, u see this instead: -->
<c:if test="${empty userBean}">
    <div class="topnav">
        <!-- Mr. Black LOGIN PAGE INCLUDE -->
        <%@include file="../../../forms/login.jsp" %>
        <ul>
            <li><a href=" http://localhost:8080/theBlog/Home "> Home </a></li>
        </ul>

    </div>

</c:if>

</body>
</html>