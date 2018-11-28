<%--
  Created by IntelliJ IDEA.
  User: Mr. Black
  Date: 28/11/2018
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%--<style>--%>
        <%--<%@include file="/WEB-INF/css/home.css" %>--%>
    <%--</style>--%>
</head>
<body>


<form style="border-radius: 5px; margin:20px 50px; float: left" class="Blog-comment" action="Comment" method="POST">
    <div>
    <textarea cols="50" rows="10" placeholder="Place your comment" name="comment"
              style="float: left; background: lightgreen; border-radius: 5px;"></textarea>
    </div>
    <div>
        <input type="submit" value="Submit" style="float: left">
    </div>
</form>


<div>
    <fieldset style="border-radius: 5px; margin:20px 50px">
    <legend><h2 style="text-align: center">Comments</h2></legend>
    <table style="margin: 50px 150px 50px 100px">
        <c:forEach items="${comment}" var="comment" varStatus="status">
            <tr>
                <td style="font-weight: bold">${comment.date}</td>
                <td style="font-weight: lighter">${comment.userComment.userName}</td>
                <td style="font-weight: lighter">${comment.comment}</td>
            </tr>
        </c:forEach>
    </table>
    </fieldset>

</div>

</body>
</html>
