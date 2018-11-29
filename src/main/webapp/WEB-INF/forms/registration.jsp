<!-- url for this page is: localhost:8080/forms/registration -->


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="myscript.js"></script>
    <style>
    <%@include file="/WEB-INF/css/registration.css" %>
</style>
</head>
<body>

<%--<div class="topnav">--%>
    <%--<a>--%>
        <%--<a href="./Home">Home</a>--%>
        <%--<form class="search-box">--%>
            <%--<input type="text" placeholder="searchTerm..."/></form>--%>
    <%--</a>--%>
<%@include file="../theBlog/fullPages/parts/header.jsp" %>
</div>
<fieldset style="border-radius: 5px; margin:20px 50px"><legend><h2 style="text-align: center">Registration Form</h2></legend>

    <div style="margin-left: 100px">
        <form method="post">

            <div class="text-field"> First Name: <br><input type="text" name="firstName"></div>

            <div class="text-field"> Last Name: <br><input type="text" name="lastName"></div>

            <div class="text-field"> E-mail Address: <br><input type="text" name="email"></div>

            <div class="text-field"> Street: <br><input type="text" name="street"></div>

            <div class="text-field"> House Number: <br><input type="text" name="houseNumber"></div>
            <img src="register.png">
            <div class="text-field"> City: <br><input type="text" name="city"></div>

            <div class="text-field"> Zip Code: <br><input type="text" name="zipCode"></div>

            <div class="text-field"> User Name: <br><input type="text" name="userName"></div>

            <div class="text-field"> Password: <br><input type="password" name="password"></div>
            <br>

            <button style="margin-top: 15px; margin-bottom: 15px" type="submit" value="SUBMIT"> Submit</button>

        </form>
    </div>
</fieldset>
</body>
</html>