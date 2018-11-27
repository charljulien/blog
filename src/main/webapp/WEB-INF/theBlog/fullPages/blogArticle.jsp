<!-- Mr. Black IMPORTANT LINE HEREUNDER MUST BE PRESENT AT ALL TIMES, THIS LINKS << ${blogPostService} >> to << BlogPostBean >> -->


<!-- url for this page should be : localhost:8080/theblog/blogpostTitle+ID -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="myscript.js"></script> <!-- ?????? -->
    <link rel="stylesheet" href="../../css/home.css">

    <title>${all.title}</title>
</head>
<body>

<div class="main">
    <div>
        <h1>Blog Article </h1>
        <h2> ${all.title} </h2>
        <p> ${all.blogMessage} </p>
        <h3> ${all.likeBlogCounter}  </h3> <!-- uploaded in real time -->

        <form action="Like" method="post">
            <input type="submit" value="Like" style="width: 50px;" name="likeCounter">
            <input type="hidden" name="blogName" value="${all.id}">
        </form>
</div>

</body>
</html>
