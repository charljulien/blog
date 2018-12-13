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
</head>

<body>
<form class="commentForm" action="Comment" method="POST">
    <div>
        <textarea class="commentTextArea" cols="50" rows="10" placeholder="Place your comment"
                  name="comment"></textarea>
    </div>
    <div>
        <input class="commentInput" type="submit" value="Submit">
    </div>
</form>

<div>
    <fieldset class="commentFieldset">
        <legend><h2 class="commentH2">Comments</h2></legend>
        <table class="commentTable">
            <c:forEach items="${blogArticle.comments}" var="comment" varStatus="status">
                <tr>
                    <td class="commentTdOne">${comment.date}</td>
                    <td class="commentTdTwo" id="userName">${comment.getUser().getUserName()}</td>
                    <td class="commentTdTwo">${comment.comment}</td>
                </tr>
            </c:forEach>
        </table>
    </fieldset>
</div>
</body>
</html>
