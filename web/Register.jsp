<%-- 
    Document   : Register
    Created on : Aug 18, 2021, 6:58:39 PM
    Author     : Domi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Register.css" />
        <title>Login page</title>
    </head>
    <body>
        <div id="formContent">
            <h1>Register</h1>
            <form action="Register" method="POST">
                <input type="text" id="Username" class="fadeIn second" name="Username" placeholder="Username">
                <input type="text" id="Password" class="fadeIn third" name="Password" placeholder="Password">
                <input type="text" id="RepeatedPassword" class="fadeIn third" name="RepeatedPassword" placeholder="Repeat Password">
                <button id="registerButton" type="submit" class="btn btn-dark fadeIn fourth ">Register</button>
            </form>
            <div id="keepBrowsing">
                <a href="/JavaWebProject">Keep browsing</a>
            </div>

        </div>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
