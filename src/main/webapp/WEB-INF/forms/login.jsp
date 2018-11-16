<!-- url for this page is: localhost:8080/forms/login -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
<h3>Log In</h3>
<div class="login-page">
    <div class="form">
        <form class="login-form" action="Login" method="POST">
            <input type="text" placeholder="username" name="userName"/>
            <input type="password" placeholder="password" name="password"/>
            <input type="submit" value ="login">
            <p class="message">Not registered? <a href="localhost:8080/forms/register">Create an account</a></p>
        </form>
    </div>
</div>
</body>
</html>

