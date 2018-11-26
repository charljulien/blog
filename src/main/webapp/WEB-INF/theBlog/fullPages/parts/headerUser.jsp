<!-- Miss Gold: NO IDEA WHAT THIS IS... Mr Black made it?? Why not use existing header? j -->

<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <script src="myscript.js"></script>
    <style>
        <%@include file="/WEB-INF/css/home.css" %>
    </style>
    <!-- miss gold is wondering if it is necessary to add this here as well? or only in complete jsp pages..-->

</head>
<body>

<form action="Registration" method="GET">
    <input type="submit" value="create an account">
</form>

<form action="Login" method="GET">
    <input type="submit" value="login" style="width: 50px;">
</form>

<form>


    <input style="width: 100px;" type="password" placeholder="password" name="password"/>
    <input style="width: 100px;" type="text" placeholder="username" name="userName"/><br>


</form>
<div class="topnav">
    <a >
        <a href="theBlog/combinationsAkaPages/blogCentral.jsp">Home</a>

        <form class="search-box">
            <input type="text" placeholder="searchTerm..."/></form></a>

</div>

</body>
</html>

