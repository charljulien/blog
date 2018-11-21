<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">
    <!-- miss gold is wondering if it is necessary to add stylesheet here as well? or only in complete jsp pages..-->
</head>
<body>

<!-- u cannot link to jsp pages, u have to go through a servlet  ; u can link to html but its better to go trough servlet??-->

<!-- condition IF 1. author is logged in OR 2. user is logged in -->
<div class="topnav">
    <form action="Home" method="GET">
        <input type="submit" value="Go to main page">
    </form>
    <a href=" http://localhost:8080/theblog/Home "> Home </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> My Profile </a>
    Search: <input type="text" value="Search" placeholder="searchTerm"/>
</div>


<!-- condition else -->
<div class="topnav">
    <form action="Home" method="GET">
        <input type="submit" value="Go to main page">
    </form>
    <a href=" http://localhost:8080/theblog/Home "> Home </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> Log In </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> Register </a>
    Search: <input type="text" value="Search" placeholder="searchTerm"/>
</div>

</body>
</html>