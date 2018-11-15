<!-- url for this page is: localhost:8080/theblog/author -->


<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<!-- retrieve from list of blog posts from said logged in author-->

<!--  basically copy paste this for each possible sort query , so by date fzu ? and alphabetially ? -->
<div class="main">
    <div>
        <h2> ${UserBean.blogs[1]} </h2>
        <p> text article one text text text text goes here text and more text text text text text text </p>
    </div>
    <div>
        <h2> ${UserBean.blogs[2]} </h2>
        <p> text article two text text text text goes here text and more text text text text text text </p>
    </div>
    <div>
        <h2> ${UserBean.blogs[3]} </h2>
        <p> text article three  text text text text goes here text and more text text text text text text </p>
    </div>
    <div>
        <h2> ${UserBean.blogs[4]} </h2>
        <p> text article four text text text text goes here text and more text text text text text text </p>
    </div>
    <div>
        <h2> ${UserBean.blogs[5]} </h2>
        <p> text article five text text text text goes here text and more text text text text text text </p>
    </div>
    <div>
        <h2> ${UserBean.blogs[6]} </h2>
        <p> text article six  text text text text goes here text and more text text text text text text </p>
    </div>
</div>

</body>
</html>