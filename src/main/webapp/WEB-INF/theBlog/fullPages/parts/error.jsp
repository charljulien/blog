<%--
  Created by IntelliJ IDEA.
  User: Charles LeMagnifique
  Date: 28/11/2018
  Time: 20:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${not empty erreur}">
    <p>Invalid username or password.</p>
</c:if>
</body>
</html>
