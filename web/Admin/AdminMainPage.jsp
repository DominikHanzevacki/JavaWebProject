<%-- 
    Document   : AdminMainPage
    Created on : Aug 13, 2021, 6:27:39 PM
    Author     : Domi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/MainPage.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Header.css" />
        <title>Admin Page</title>
    </head>
    <header>
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container-fluid">
                <a class="navbar-brand" href="AdminMainPage.jsp">Admin home page</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="navbar-collapse collapse" id="navbarNav">
                    <ul class="navbar-nav ms-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="AddNewBall.jsp">
                                <i class="fa fa-volleyball-ball" style="font-size:20px;"></i> Add new Ball
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="AddNewCategory.jsp">
                                <i class="fa fa-list-ul" style="font-size:20px;"></i> Add new Category
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ViewLoginHistories.jsp">
                                <i class="fa fa-user" style="font-size:20px;"></i> View all login histories
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="ViewAllPurchases.jsp">
                                <i class="fa fa-shopping-cart" style="font-size:20px;"></i> View all purchases
                            </a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/JavaWebProject">
                                <i class="fa fa-sign-in-alt" style="font-size:20px;"></i> Log out
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
    </header>
    <body>
        <img src="../Pictures/BallShop.jpg" class="img-fluid" alt="Main page picture">
        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script><script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    </body>
</html>
