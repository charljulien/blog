<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">
    <!-- miss gold is wondering if it is necessary to add this here as well? or only in complete jsp pages..-->
</head>
<body>

<div class="topnav">
    <a href="theBlog/combinationsAkaPages/blogCentral.jsp">Home</a>
    <a href="forms/logIn.jsp">Log In</a>
    <a href="forms/registration">Sign Up</a>
    Search: <input type="text" value="Search" placeholder="searchTerm"/>
    <form action="Login" method="GET">
        <input type="submit" value="login">
    </form>
    <form action="Registration" method="GET">
        <input type="submit" value="create an account">
    </form>
</div>

</body>
</html>
