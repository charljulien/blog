<%--<!-- Mr. Black IMPORTANT LINE HEREUNDER MUST BE PRESENT AT ALL TIMES, THIS LINKS --%>
<%--${userBean.userName} TO <<USERBEAN >> -->--%>
<%--<jsp:userBean id="userBean" scope="session" type="be.intecbrussel.blogProject.beans.UserBean"/>--%>
<!-- M. Gold : but it's in comments.. how does it help than? -->

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Miss Gold: is this necessary here AND in parts?? -->
<!-- url for this page is: localhost:8080 or host(www.theblog.com)/theblog/blogcentral -->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Blog Central</title>
    <link rel="stylesheet" href="../css/styles.css">
</head>

<body>

<c:if test="${not empty userBean}">
    <p>You're logged in.</p>
    <h1>WELCOME ${userBean.userName}</h1>
    <!-- Mr. Black to get << BlogPostServlet >> to make a post -->
    <div class="button" name="createBlog">
        <div class="header">
            <%@include file="parts/header.jsp" %>
        </div>
        <form action="Post" method="GET">
            <input type="submit" value="create Post">
        </form>
    </div>
</c:if>
<!-- Miss Gold to Mr Black: love what u did here ( above, and under ) and that u got it to work but this needs to be a header functionality.. has nothing to do with body, I will change this after we discuss it -->
<!-- also, i saw u deleted CreateBlogPostServlet : we need a new page for that.. you want to add it as a method to BlogPostServlet instead? (and link to new JSP?) what method do u suggest? since doGet and doPost are both already taken.  --->

<c:if test="${empty userBean}">
    <p>You're not logged in!</p>
    <div class="header">
        <%@include file="parts/header.jsp" %>
    </div>
</c:if>

<div>
    <%@include file="./parts/sidebar.jsp" %>
</div>

<div>
    <%--<%@include file="./parts/blogCentralBody.jsp" %>--%>
</div>

</body>
</html>