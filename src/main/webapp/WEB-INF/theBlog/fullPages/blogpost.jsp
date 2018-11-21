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

    <title>${BlogPostBean.title}</title>
</head>
<body>

<div class="main">
    <div >
        <h2> ${blogPostBean.title} </h2>
        <p> ${blogPostBean.blogMessage} </p>
    </div>
    <div>
        <h3> ${blogPostBean.likes} Likes </h3> <!-- uploaded in real time -->
    </div>
    <div>
        <button onclick="myFunction()" > LIKE </button> <!-- action here goes to method that adds another like to the bunch ; can i add java function instead of js?-->
    </div>
</div>

</body>
</html>
