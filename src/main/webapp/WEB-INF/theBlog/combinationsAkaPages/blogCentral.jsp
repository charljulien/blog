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
<div>
    <%@include file="./parts/headerUser.jsp" %>
</div>
<div>
    <%@include file="./parts/sidebar.jsp" %>
</div>
<%@taglib prefix="c"% uri="http://java.sun.com/jsp/jstl/core"%>
    <div>
    <c:forEach items="§{blogposts}" var="blogpost" varStatus="what?">
        <tr>
        <td>
        ${blogpost.title}
        </td>
        <td>
        ${blogpost.text}
        </td>
        <a href ="BlogPost?"> ... </a> <!-- continue reading aka go to detail page -->
        </tr>
        </div>
</body>
</html>

