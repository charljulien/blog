<!-- url for this page is: localhost:8080 or host(www.theblog.com)/theblog/blogcentral -->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
<header>
    <div class="title"> The Blog</div>
    <div class="nav-bar">
        <%@ include file="/WEB-INF/theBlog/parts/header.jsp" %>
    </div>
</header>
<div class="main">
    <h2> Title </h2>
    <p> text </p>

</div>
<sidebar class="sidebar">
    <div>
        <%@ include file="/WEB-INF/theBlog/parts/sidebar.jsp" %>
    </div>
</sidebar>
</body>
</html>

