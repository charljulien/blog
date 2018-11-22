<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- is this necessary here AND in parts?? -->
<!-- url for this page is: localhost:8080 or host(www.theblog.com)/theblog/blogcentral -->

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

<!-- Mr Black: Used line below to verify that session of user is being saved and can be accessed -->
<h1>WELCOME LORD ${userBean.userName}</h1>

<div>
    <%@include file="parts/header.jsp" %>
</div>
<div>
    <%@include file="./parts/sidebar.jsp" %>
</div>

<div>
    <%@include file="./parts/blogCentralBody.jsp" %>
</div>

</body>
</html>

