


<!-- I do need JTSL for this .. -->

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

<!-- condition IF author is logged in ; than u see the following: -->
<div class="topnav">
    <a href=" http://localhost:8080/theblog/Home "> Home </a>
    <a href=" http://localhost:8080/theblog/CreateBlogPost "> Create Blog Post </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> My Profile </a> <!-- in my profile my author page OR when u click on name in any article -->
    Search: <input type="text" value="Search" placeholder="searchTerm"/>
</div>

<!-- condition IF ELSE user is logged in ; than u see the following: -->
<div class="topnav">
  <!-- alternative to a href, mr pink prefers so must change ALL OR learn to use alternative and teach everyone -->
    <!--
    <form action="Home" method="GET">
        <input type="submit" value="Go to main page">
    </form> -->
    <a href=" http://localhost:8080/theblog/Home "> Home </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> My Profile </a>
    Search: <input type="text" value="Search" placeholder="searchTerm"/>
</div>

<!-- condition else, u see this instead: -->
<div class="topnav">
    <a href=" http://localhost:8080/theblog/Home "> Home </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> Register </a>
    <a href=" http://localhost:8080/theblog/UserProfile "> Log In </a>
    Search: <input type="text" value="Search" placeholder="searchTerm"/>
</div>

</body>
</html>