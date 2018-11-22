<<<<<<< HEAD
<!-- Mr. Black IMPORTANT LINE HEREUNDER MUST BE PRESENT AT ALL TIMES, THIS LINKS ${userBean.userName} TO <<USERBEAN >> -->
<jsp:useBean id="userBean" scope="session" type="be.intecbrussel.blogProject.beans.UserBean"/>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
=======
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- is this necessary here AND in parts?? -->
>>>>>>> 97ceabf20c785d2bd868304036661636acf98825
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

<<<<<<< HEAD


<!-- Used line below to verify that session of user is being saved and can be accessed -->
=======
<!-- Mr Black: Used line below to verify that session of user is being saved and can be accessed -->
>>>>>>> 97ceabf20c785d2bd868304036661636acf98825
<h1>WELCOME LORD ${userBean.userName}</h1>
<!-- Mr. Black to get << BlogPostServlet >> to make a post -->
<form action="Post" method="GET">
    <input type="submit" value="create Post">
</form>


<div>
    <%@include file="parts/header.jsp" %>
</div>
<div>
    <%@include file="./parts/sidebar.jsp" %>
</div>

<div>
    <%@include file="./parts/blogCentralBody.jsp" %>
</div>

</body>
</html>

