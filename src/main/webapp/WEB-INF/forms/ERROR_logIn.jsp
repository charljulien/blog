<!-- url for this page is: localhost:8080/forms/login ; can it be the same url and still another jsp aka another html generated page? yes, right? -->


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>
<h3>Log In</h3>

<p> ERROR LOGGING YOU IN. CHECK YOUR USERNAME AND PASSWORD AND THAN TRY AGAIN. </p>

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