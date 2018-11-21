<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<div>
 <c:forEach items="§{blogs}" var="blogPostBean" >
  <tr>
   <td>
     ${blogPostBean.blogMessage}
   </td>
   <td>
     ${blogPostBean.blogMessage}
   </td>
   <a href ="http://localhost:8080/theblog/Post"> ... </a> <!-- continue reading aka go to detail page -->
  </tr>
 </c:forEach>
</div>