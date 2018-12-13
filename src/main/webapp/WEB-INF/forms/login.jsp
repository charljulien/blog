<!-- url for this page is: localhost:8080/forms/login -->

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
        <%@include file="../css/home.css" %>
    </style>
</head>
<body>

<form action="Registration" method="GET">
    <input class="loginInputOne" type="submit" value="create an account">
</form>
<form action="Login" method="Post">
    <input class="loginInputTwo" type="submit" value="login">
    <input class="loginInputThree" type="password" placeholder="password" name="password"/>
    <input class="loginInputThree" type="text" placeholder="username" name="userName"/>
</form>
</body>
</html>

