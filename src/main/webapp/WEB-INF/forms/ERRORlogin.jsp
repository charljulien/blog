<%@ taglib prefix="portlet" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- url for this page is: localhost:8080/forms/login ; can it be the same url and still another jsp aka another html generated page? yes, right? -->


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="myscript.js"></script>

    <link rel="stylesheet" href="login.css">
</head>
<body>

<center>
    <h3 style="font-size: 20px; ">ERROR LOGGING YOU IN. CHECK YOUR USERNAME AND PASSWORD AND THAN TRY AGAIN.</h3>
    <div class="login-page">
        <div class="form">
            <form class="login-form" action="Login" method="POST">

                <input style="width: 200px;" type="text" placeholder="username" name="userName"/><br>
                <input style="width: 200px;" type="password" placeholder="password" name="password"/><br>
                <input type="submit" value ="login">

            </form>
            <form action="Registration" method="GET">
                <input type="submit" value="create an account" style="width: 120px;">
            </form>

        </div>
    </div>
</center>

</body>
</html>