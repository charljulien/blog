<!-- url for this page is: localhost:8080/forms/login ; can it be the same url and still another jsp aka another html generated page? yes, right? -->


<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Insert title here</title>
</head>
<body>

<p> ERROR LOGGING YOU IN. CHECK YOUR USERNAME AND PASSWORD AND THAN TRY AGAIN. </p>

<h3> Log in </h3>
<div class="login-page">
    <div class="form">
        <form class="login-form">
            <input type="text" placeholder="username"/>
            <input type="password" placeholder="password"/>
            <button>login</button>
            <p class="message">Not registered? <a href="localhost:8080/forms/register">Create an account</a></p>
        </form>
    </div>
</div>

</body>
</html>