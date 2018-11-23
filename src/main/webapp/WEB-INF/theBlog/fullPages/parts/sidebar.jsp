<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="styles.css" media="screen"/>
    <script src="myscript.js"></script>
</head>
<body>


<div class="sidenav">
    <div>
        <a href="#loggedInUsers">${loggedInUserService.listLoggedInUsers.toString}</a>
    </div>
    <div>
        <!-- how do I best access this ? via method? --> <!-- how do I add : X is logged in fzu -->
        <a href="#loggedInUsersTotal"> Active users : ${loggedInUserService.listLoggedInUsers.length}</a>
    </div>
    <div>
        <a href="#usersSoFar"> Total blog users: ${loggedInUserService.listUsersTotal.length}</a>
    </div>
</div>


<div class="topnav">
Search: <input type="text" value="Search" placeholder="searchTerm"/>
</div>


</body>
</html>
