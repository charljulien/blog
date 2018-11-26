<%--
  Created by IntelliJ IDEA.
  User: Charles LeMagnifique
  Date: 26/11/2018
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div>
    <p>Below are the information linked to your profile:</p>
    <ul>
        <li>First name: ${userBean.firstName}</li>
        <li>Last name: ${userBean.lastName}</li>
        <li>Username: ${userBean.userName}</li>
        <li>Email: ${userBean.email}</li>
        <li>Street: ${userBean.street}</li>
        <li>House number: ${userBean.houseNr}</li>
        <li>City: ${userBean.city}</li>
        <li>Zip code: ${userBean.zipCode}</li>
        <li>Password: ${userBean.password}</li>
    </ul>
    <p>Your post history:</p>
    <a href=" http://localhost:8080/theblog/AuthorPage "> Author page </a>
</div>

</body>
</html>
