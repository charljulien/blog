<!-- url for this page is: localhost:8080/forms/login -->

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h3>Log In</h3>

<form method="post" action="getsession">
    <input type="text" name="userName"/>
    <input type="password" name="password"/>
    <button>Log In</button>
</form>

<form method="post" action="logout">
    <button>Log Out</button>
</form>


</body>
</html>