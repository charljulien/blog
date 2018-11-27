<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Charles LeMagnifique
  Date: 26/11/2018
  Time: 13:04
  To change this template use File | Settings | File Templates.
--%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<%@include file="../parts/header.jsp" %>
<fieldset style="border-radius: 5px; margin:20px 50px">
    <legend><h3 style="text-align: center">Information linked to your profile:</h3></legend>
    <div id="userProfile">

        <pre>
             First name:         <small>${userBean.firstName}</small>
             Last name:          <small>${userBean.lastName}</small>
             Username:          <small>${userBean.userName}</small>
             Email:                 <small>${userBean.email}</small>
             Street:                <small>${userBean.street}</small>
             House number:   <small>${userBean.houseNr}</small>
             City:                    <small>${userBean.city}</small>
             Zip code:             <small>${userBean.zipCode}</small>
             Password:            <small>${userBean.password}</small></pre>

        <p>Your post history:
        <a href="./AuthorPage"> Author page </a></p>
    </div>
</fieldset>

</body>
</html>
