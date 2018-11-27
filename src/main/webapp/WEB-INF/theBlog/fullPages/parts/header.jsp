<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="myscript.js"></script>
    <style>
        <%@include file="../../../css/home.css" %>
    </style>
</head>


<body>
<!-- condition IF user is logged in ; than u see the following: -->
<c:if test="${not empty userBean}">
    <div class="topnav">
        <ul>
            <li><a href="./Home"> Home </a></li>
            <li><a href="./UserProfile"> My Profile </a></li>
            <li><form action="Post" method="post"><a href="Post"> Create Blog</a> </form></li>

            <form class="logout" action="Logout" method="get" style="float:right">
                <li><input style="margin-right: 15px; margin-left: 15px" type="submit" value="Logout"> <p class="active"> Welcome ${userBean.userName}</p> </li>
            </form>
        </ul>
    </div>
</c:if>

<!-- condition IF author is logged in ; than u see the following: -->
<c:if test="${(not empty userBean) && (memberAcces = author) }">

    <div class="topnav">
        <ul>
            <li>
                <a href="./Home"> Home </a>
            </li>
            <li>
                <div class="button" name="createBlog">
                    <form action="Post" method="GET">
                        <input type="submit" value="create Post">
                    </form>
                </div>
            </li>
            <li>
                <a href="./UserProfile"> My Profile </a>
            </li>
            <li>
                Search: <input type="text" value="Search" placeholder="searchTerm"/>
            </li>
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