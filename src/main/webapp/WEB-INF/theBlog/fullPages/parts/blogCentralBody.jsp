<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%--for each put in comment by mr pink to test the servlet--%>
<%--for each itself still doesn't work--%>
<div>
    ${blogPostBean.getAllBlogs}<!-- EL methode gebruiken en via query zoeken -->

    <%--</div>--%>

    <%--<div>--%>
    <%--<c:forEach items="§{blogposts}" var="blogpost" varStatus="status">--%>
    <%--<tr>--%>
    <%--<td>--%>
    <%--${blogpost.title}--%>
    <%--</td>--%>
    <%--<td>--%>
    <%--${blogpost.text}--%>
    <%--</td>--%>
    <%--<a href ="BlogPost?"> ... </a> <!-- continue reading aka go to detail page -->--%> <!-- make button or form  -->
    <%--</tr>--%>
    <%--</div>--%>
    <%--</c:forEach>--%>


    <c:if test="${}">
        <p>You're logged in.</p>
        <h1>WELCOME ${userBean.userName}</h1>
        <!-- Mr. Black to get << BlogPostServlet >> to make a post -->
        <div class="button" name="createBlog">
            <div class="header">
                <%@include file="parts/header.jsp" %>
            </div>
            <form action="Post" method="GET">
                <input type="submit" value="create Post">
            </form>
        </div>
    </c:if>
    <!-- Miss Gold to Mr Black: love what u did here ( above, and under ) and that u got it to work but this needs to be a header functionality.. has nothing to do with body, I will change this after we discuss it -->
    <!-- also, i saw u deleted CreateBlogPostServlet : we need a new page for that.. you want to add it as a method to BlogPostServlet instead? (and link to new JSP?) what method do u suggest? since doGet and doPost are both already taken.  --->

    <c:if test="${empty userBean}">
        <p>You're not logged in!</p>
        <div class="header">
            <%@include file="parts/header.jsp" %>
        </div>
    </c:if>
</div>