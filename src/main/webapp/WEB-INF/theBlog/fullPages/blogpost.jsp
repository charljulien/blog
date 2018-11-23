<!-- Mr. Black IMPORTANT LINE HEREUNDER MUST BE PRESENT AT ALL TIMES, THIS LINKS << ${blogPostService} >> to << BlogPostBean >> -->
<jsp:useBean id="blogPostService" scope="session" type="be.intecbrussel.blogProject.beans.BlogPostBean"/>


<!-- url for this page should be : localhost:8080/theblog/blogpostTitle+ID -->
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">

    <title>${blogPostService.title}</title>
</head>
<body>

<div class="main">
    <div >
        <h1>BLOG POSTED BY ${blogPostService.user.userName}</h1>
        <h2> ${blogPostService.title} </h2>
        <p> ${blogPostService.blogMessage} </p>
    </div>
    <div>
        <h3> ${blogPostService.likeBlogCounter} Likes </h3> <!-- uploaded in real time -->
    </div>
    <div>
        <form class="Like-Blog" action="Like" method="POST">
            <input type="submit" value="LIKE Blog" name="likeCounter">
        </form>

        <button onclick="myFunction()" > LIKE </button> <!-- action here goes to method that adds another like to the bunch ; can i add java function instead of js?-->
    </div>
</div>

</body>
</html>
