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
<div>
    <%@include file="parts/header.jsp" %>
</div>
<div>
    <%@include file="./parts/sidebar.jsp" %>
</div>
<!-- include body author page with the articles of said author -->
<div>
    <%@include file="parts/authorPageBody.jsp" %>
</div>

</body>
</html>