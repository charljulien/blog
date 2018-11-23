<!-- url for this page is: localhost:8080/forms/registration -->


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="registration.css">
</head>
<body>
<h3>Registration Form:</h3>

<div>
    <form method="post">
        <div class="text-field"> First Name: <br><input type="text" name="firstName"></div>

        <div class="text-field"> Last Name: <br><input type="text" name="lastName"></div>

        <div class="text-field"> E-mail Address: <br><input type="text" name="email"></div>

        <div class="text-field"> Street: <br><input type="text" name="street"></div>

        <div class="text-field"> House Number: <br><input type="text" name="houseNumber"></div>

        <div class="text-field"> City: <br><input type="text" name="city"></div>

        <div class="text-field"> Zip Code: <br><input type="text" name="zipCode"></div>

        <div class="text-field"> User Name: <br><input type="text" name="userName"></div><br>

        <div class="text-field"> Password: <br><input type="password" name="password"></div><br>

        <button type="submit" value="SUBMIT"> Submit</button>
    </form>
</div>

</body>
</html>