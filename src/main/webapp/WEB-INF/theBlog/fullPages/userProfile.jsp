<!-- url for this page is: localhost:8080/theblog/userprofile -->
<!-- unreachable unless you are said user AND logged in -->

<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
    <script src="myscript.js"></script>
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<div class="userProfileINFO">
    <div>
        <p>First name :${userBean.firstName}</p>
    </div>
    <div>
        <p>Last name :${userBean.lastName}</p>
    </div>
    <div>
        <p>E-mail Address :${UserBean.emailAddress}</p>
    </div>
    <div>
        <p>Street :${UserBean.street}</p>
    </div>
    <div>
        <p>House Number :${UserBean.houseNumber}</p>
    </div>
    <div>
        <p>City :${UserBean.city}</p>
    </div>
    <div>
        <p>Zip Code :${UserBean.zipcode}</p>
    </div>
    <div>
        <p>Username :${UserBean.username}</p>
    </div>
</div>
<div>
    <button > EDIT USER INFO </button>
</div>

</body>
</html>