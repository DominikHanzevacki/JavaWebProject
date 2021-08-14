<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Login.css" />
        <title>Login page</title>
    </head>
    <body>
        <div id="formContent">
            <h1>Login:</h1>
            <form action="j_security_check" method="POST">
                <input type="text" id="loginUsername" class="fadeIn second" name="j_username" placeholder="Username">
                <input type="text" id="loginPassword" class="fadeIn third" name="j_password" placeholder="Password">
                <button id="loginButton" type="submit" class="btn btn-dark fadeIn fourth ">Log In</button>
            </form>
            <div id="forgotPassword">
                <h7>Don't have an account?</h7>
                <h7>Register:</h7>
                <br>
                <a href="#">Register?</a> | <a href="/JavaWebProject">Keep browsing</a>
            </div>

        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
