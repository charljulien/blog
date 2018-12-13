<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <style>
    <%@include file="/WEB-INF/css/home.css" %>
</style>
</head>
<body>

<%@include file="../theBlog/fullPages/parts/header.jsp" %>

</div>
<fieldset class="registrationFieldset">
    <legend><h2 class="registrationH2">Registration Form</h2></legend>

    <div class="registrationDiv">
        <form method="post">

            <div class="registrationTextField"> First Name: <br>
                <input class="registrationInput" type="text" name="firstName"></div>

            <div class="registrationTextField"> Last Name: <br>
                <input class="registrationInput" type="text" name="lastName"></div>

            <div class="registrationTextField"> E-mail Address: <br>
                <input class="registrationInput" type="text" name="email"></div>

            <div class="registrationTextField"> Street: <br>
                <input class="registrationInput" type="text" name="street"></div>

            <div class="registrationTextField"> House Number: <br>
                <input class="registrationInput" type="text" name="houseNumber"></div>

            <div class="registrationTextField"> City: <br>
                <input class="registrationInput" type="text" name="city"></div>

            <div class="registrationTextField"> Zip Code: <br>
                <input class="registrationInput" type="text" name="zipCode"></div>

            <div class="registrationTextField"> User Name: <br>
                <input class="registrationInput" type="text" name="userName"></div>

            <div class="registrationTextField"> Password: <br>
                <input class="registrationInput" type="password" name="password"></div>
            <br>

            <button class="registrationButton" type="submit" value="SUBMIT"> Submit</button>

        </form>
    </div>
</fieldset>
</body>
</html>