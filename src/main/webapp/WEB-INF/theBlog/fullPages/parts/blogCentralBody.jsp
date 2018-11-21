<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--for each put in comment by mr pink to test the servlet--%>
<%--for each itself still doesn't work--%>
<div>
 ${blogPostBean.blogMessage}
 <%--<c:forEach items="§{blogs}" var="blogPostBean" >--%>
  <%--<tr>--%>
   <%--<td>--%>
     <%--${blogPostBean.blogMessage}--%>
   <%--</td>--%>
   <%--<td>--%>
     <%--${blogPostBean.blogMessage}--%>
   <%--</td>--%>
   <%--<a href ="http://localhost:8080/theblog/Post"> ... </a> <!-- continue reading aka go to detail page -->--%>
  <%--</tr>--%>
 <%--</c:forEach>--%>
</div>