<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- url for this page is: localhost:8080 or host(www.theblog.com)/theblog/blogcentral -->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<!-- Used line below to verify that session of user is being saved and can be accessed -->
<h1>WELCOME LORD ${userBean.userName}</h1>


<div>
    <%@include file="parts/header.jsp" %>
</div>
<div>
    <%@include file="./parts/sidebar.jsp" %>
</div>
<%--<div>--%>
<%--<c:forEach items="§{blogposts}" var="blogpost" varStatus="what?">--%>
    <%--<tr>--%>
    <%--<td>--%>
    <%--${blogpost.title}--%>
    <%--</td>--%>
    <%--<td>--%>
    <%--${blogpost.text}--%>
    <%--</td>--%>
    <%--<a href ="BlogPost?"> ... </a> <!-- continue reading aka go to detail page -->--%>
    <%--</tr>--%>
    <%--</div>--%>


    <!-- this needs a counter = to only show the first six, and every time someone presses the more button the counter increases its capacity with 6 more
    in java this would be a do while loop and in the while id be able to change the condition -->
    <%--Miss Gold to Mrs Black : Steven, kan je een lijst maken van alle bestaande blogs aub?       Mr. Black --> this is done! --%>
    <div>
    <%@include file="./parts/blogCentralBody.jsp" %>
    </div>

    </body>
    </html>

