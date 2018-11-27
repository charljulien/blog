<%@ page contentType="text/html, charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h1> Blog List </h1>

    <table>

        <jsp:useBean id="BlogPostBean" scope="session" type="java.util.List"/>
        <jsp:useBean id="byDate" scope="session" type="be.intecbrussel.blogProject.beans.BlogPostBean"/>
        <c:forEach items="${byDate}" var="bydate" varStatus="status">
            <tr>
                <td>${status.index}</td>
                <td>${byDate.user}</td>
                <td>${byDate.title}</td>
                <td>${byDate.blogMessage}</td>
            </tr>
        </c:forEach>
    </table>


</body>
</html>g