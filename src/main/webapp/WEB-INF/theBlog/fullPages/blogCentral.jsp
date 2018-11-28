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
    <link rel="stylesheet" href="../../css/home.css">
</head>

<body>
<<<<<<< HEAD
<!-- Mr. Black to get << BlogPostServlet >> to make a post -->
<div class="header">
    <%@include file="parts/header.jsp" %>
</div>
=======
    <div>
        <%@include file="parts/error.jsp"%>
    </div>

    <!-- Mr. Black to get << BlogPostServlet >> to make a post -->
    <div class="header">
        <%@include file="parts/header.jsp" %>
    </div>
>>>>>>> 40fd5d321f5c19beb252d8ba50efe6edb2a91322
<!-- Miss Gold to Mr Black: love what u did here ( above, and under ) and that u got it to work but this needs to be a header functionality.. has nothing to do with body, I will change this after we discuss it -->
<!-- also, i saw u deleted BlogArticle : we need a new page for that.. you want to add it as a method to BlogPostServlet instead? (and link to new JSP?) what method do u suggest? since doGet and doPost are both already taken.  --->

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