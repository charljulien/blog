<!-- url for this page is: localhost:8080/forms/login -->

<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="../../css/login.css" type="text/css">

</head>
<body>

    <div class="login-page">
        <div class="form" style="float: right">
            <form class="login-form" action="Login" method="POST">

                <input  type="text" placeholder="username" name="userName"/>
                <input  type="password" placeholder="password" name="password"/>
                <input type="submit" value ="login">

                <form action="Registration" method="GET">
                    <input type="submit" value="Register">
                </form>

            </form>

        </div>
    </div>
</body>
</html>

