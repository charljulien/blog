<!-- url for this page is: localhost:8080/forms/login -->

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="myscript.js"></script>
    <style>
        <%@include file="../css/home.css" %>
    </style>
</head>
<body>

<form action="Registration" method="GET">
    <input type="submit" value="create an account" style="  margin-right:15px;">
</form>
<form action="Login" method="Post">
    <input type="submit" value="login" style="width: 50px;">
    <input style="width: 100px;" type="password" placeholder="password" name="password"/>
    <input style="width: 100px;" type="text" placeholder="username" name="userName"/>
</form>


<%--<div class="topnav">--%>
<%--<a>--%>
<%--<form class="search-box">--%>
<%--<input type="text" placeholder="searchTerm..."/></form>--%>
<%--</a>--%>

<%--</div>--%>
</body>
</html>

