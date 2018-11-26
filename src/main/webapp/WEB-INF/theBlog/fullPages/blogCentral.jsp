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



    <!-- Mr. Black to get << BlogPostServlet >> to make a post -->
    <div class="header">
        <%@include file="parts/header.jsp" %>
    </div>
<!-- Miss Gold to Mr Black: love what u did here ( above, and under ) and that u got it to work but this needs to be a header functionality.. has nothing to do with body, I will change this after we discuss it -->
<!-- also, i saw u deleted CreateBlogPostServlet : we need a new page for that.. you want to add it as a method to BlogPostServlet instead? (and link to new JSP?) what method do u suggest? since doGet and doPost are both already taken.  --->



<div>
    <h1>coucou c'est le blogcentralbody</h1>

 <table>
     <p>The blogs are here...?</p>
     <c:forEach items="${all}" var="blog" end="6" varStatus="status">
         <tr>
            <td>${blog.title}</td>
             <td>${blog.blogMessage}</td>
             <td>${blog.user.userName}</td>
         </tr>
     </c:forEach>
 </table>


    <%--Mr Gold needs to fix this jsp--%>
    <%--no header in it--%>
    <%--fix blogPostBean conflict--%>
<%--<%@include file="./parts/blogCentralBody.jsp" %>--%>
</div>

</body>
</html>