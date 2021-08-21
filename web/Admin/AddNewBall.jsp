<%@page import="Constants.Constants"%>
<%@ taglib uri="/WEB-INF/tlds/JavaWebtag_library" prefix="tag"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" crossorigin="anonymous">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/AddNewTable.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/Header.css" />
        <title>Add new ball</title>
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
        <form action="../BallCRUD" method="POST">
            <div id="buttonsAndInputs">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <b><p>Ball Name:</p></b>    
                        </div>
                        <div class="col">
                            <input type="text" id="BallName" class="fadeIn second" name="BallName" placeholder="Ball name">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <b> <p>Balls price:</p></b>
                        </div>
                        <div class="col">
                            <input type="number" id="BallsPrice" class="fadeIn second" name="BallsPrice" placeholder="Balls price">
                        </div>                 
                    </div>
                    <div class="row">
                        <div class="col">
                            <b> <p>Balls left:</p></b>
                        </div>
                        <div class="col">
                            <input type="number" id="BallsLeft" class="fadeIn second" name="BallsLeft" placeholder="Balls left">
                        </div>              
                    </div>
                    <div class="row">
                        <div class="col">
                            <b><p>Ball description:</p></b>
                        </div>
                        <div class="col">
                            <input type="text" id="BallDescription" class="fadeIn second" name="BallDescription" placeholder="Ball description">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <b> <p>Ball type:</p></b>
                        </div>
                        <div class="col">
                            <input type="number" id="BallType" class="fadeIn second" name="BallType" placeholder="Ball type">
                            <input type="hidden" id="RowID" name="RowID">
                        </div>
                    </div>
                    <div class="row">
                        <div class="col">
                            <b> <p>Picture:</p></b>
                        </div>
                        <div id="PictureRow">
                            <div class="col">
                                <input type="text" id="Picture" class="fadeIn second" name="Picture" placeholder="Picture">
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div id="crudButtons">
                <div class="row">
                    <div class="col">
                        <button name="CreateNewBall" type="submit" class="btn btn-secondary" value="create">Create new ball</button>
                    </div>
                    <div class="col">
                        <button name="UpdateBall" type="submit" class="btn btn-secondary" value="update">Update ball</button>
                    </div>
                    <div class="col">
                        <button name="DeleteBall" type="submit" class="btn btn-secondary" value="delete">Delete ball</button>
                    </div>
                </div>
            </div>
        </form>
        <div id="NewTable">
            <table class="table table-dark">
                <tag:AddNewBall/>
            </table>
        </div>

        <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>       
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-U1DAWAznBHeqEIlVSCgzq+c9gqGAJn5c/t99JyeKa9xxaYpSvHU5awsuZVVFIhvj" crossorigin="anonymous"></script><script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
        <script>
            jQuery(document).ready(function ($) {
                $(".clickable-row").click(function (e) {
                    var tableRows = document.querySelectorAll('#ballTable tr');
                    for (let i = 0; i < tableRows.length; i++) {
                        if (e.currentTarget.id === tableRows[i].id) {
                            document.getElementById("RowID").value = tableRows[i].getElementsByTagName("td")[0].innerText;
                            document.getElementById("BallName").value = tableRows[i].getElementsByTagName("td")[1].innerText;
                            document.getElementById("BallsPrice").value = tableRows[i].getElementsByTagName("td")[2].innerText;
                            document.getElementById("BallsLeft").value = tableRows[i].getElementsByTagName("td")[3].innerText;
                            document.getElementById("BallDescription").value = tableRows[i].getElementsByTagName("td")[4].innerText;
                            document.getElementById("BallType").value = tableRows[i].getElementsByTagName("td")[5].innerText;
                            document.getElementById("Picture").value = tableRows[i].getElementsByTagName("td")[6].attributes.name.value;
                        }
                    }



                });
            });
        </script>
    </body>
</html>
