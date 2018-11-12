<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>

    </style>
</head>
<body>

<div class="sidenav">
    <a href="#loggedInUsers">${loggedInUserService.listLoggedInUsers.toString}</a> <!-- how do I best access this ? via method? --> <!-- how do I add : X is logged in fzu -->
    <a href="#loggedInUsersTotal"> Active users : ${loggedInUserService.listLoggedInUsers.length}</a>
    <a href="#usersSoFar"> Total blog users: ${loggedInUserService.listUsersTotal.length}</a>
</div>

</body>
</html>
