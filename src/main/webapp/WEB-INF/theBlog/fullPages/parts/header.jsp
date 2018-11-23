<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% <jsp:userBean id="userBean" scope="session" type="be.intecbrussel.blogProject.beans.UserBean"/>--%>
<!-- I do need JTSL for this .. -->

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="myscript.js"></script>
    <style>
        <%@include file="/WEB-INF/css/styles.css" %>
    </style>
    <!-- miss gold is wondering if it is necessary to add stylesheet here as well? or only in complete jsp pages..-->
</head>
<body>
<!-- condition IF user is logged in ; than u see the following: -->
<c:if test="${not empty userBean && memberAcces not author}">
    <div class="topnav">
        <ul>
            <li>
                <h1>WELCOME ${userBean.userName}</h1>
            </li>
            <li>
                <a href=" http://localhost:8080/theblog/Home "> Home </a>
            </li>
            <li>
                <a href=" http://localhost:8080/theblog/UserProfile "> My Profile </a>
                <!-- in my profile my author page OR when u click on name in any article -->
            </li>
            <li>
                <a href="http://localhost:8080/theblog/LogOut"> Log Out </a>
            </li>
            <li>
                Search: <input type="text" value="Search" placeholder="searchTerm"/>
            </li>
        </ul>
    </div>
</c:if>

<!-- condition IF author is logged in ; than u see the following: -->
<c:if test="${(not empty userBean) && (memberAcces = author) }"> <!-- EL problems : invalid EL locations or unresolved references.. SOLVE!!!-->
    <!-- this is not java !!! how to resolve according to jstl? -->
    <div class="topnav">
        <ul>
            <li>
                <a href=" http://localhost:8080/theblog/Home "> Home </a>
            </li>
            <li>
                <!-- div is 'bigger' than li, of ul, so i dont think this is the appropriate way to stash them.. -->
                <!-- could also be this: <a href=" http://localhost:8080/theblog/CreateBlogPost "> Create Blog Post </a> Maybe would be better for li ??-->
                <div class="button" name="createBlog">
                    <form action="Post" method="GET">
                        <input type="submit" value="create Post">
                    </form>
                </div>
            </li>
            <li>
                <a href=" http://localhost:8080/theblog/UserProfile "> My Profile </a>
                <!-- includes a my author page !!!! -->
                <!-- in my profile my author page OR when u click on name in any article -->
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
        <ul>
            <li>
                <a href=" http://localhost:8080/theblog/Home "> Home </a>
            </li>
            <li>
                <a href=" http://localhost:8080/theblog/UserProfile "> Register </a>
            </li>
            <li>
                <a href=" http://localhost:8080/theblog/UserProfile "> Log In </a>
            </li>
            <li>
                Search: <input type="text" value="Search" placeholder="searchTerm"/>
            </li>
        </ul>
    </div>
</c:if>

</body>
</html>