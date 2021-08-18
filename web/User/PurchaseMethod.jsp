<%@page import="Sessions.Session"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <link rel="stylesheet" href="https://pro.fontawesome.com/releases/v5.10.0/css/all.css"/>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/CSS/PurchaseMethod.css" />
        <title>Purchase Method</title>
    </head>
    <body>
        <form action="../PurchaseMethod" method="POST">
            <div id="PayPalContainer">
                <h1>Choose purchase method: </h1>
                <button id="CashMethodButton" name="CashMethodButton" type="submit" class="btn bg-dark"><i class="fas fa-coins"></i> Cash</button>
                <h1>or</h1>
            </div>
            <script src="https://www.paypal.com/sdk/js?client-id=AXQKePl5i6_KKAm_sfSgAj3NxHnE2j58qFHYwVC7H7oCtvjExCVKzoUvAg_G9JE-oFfnYHFDCP3co4Ij"></script>
            <script>
                paypal.Buttons({
                    createOrder: function (data, actions) {
                        return actions.order.create({
                            purchase_units: [{
                                    amount: {
                                        value: <%= session.getAttribute(Session.SUM_OF_PRICES).toString().trim().substring(0, 4)%>
                                    }
                                }]
                        });
                    }
                }).render('#PayPalContainer');

            </script>
        </form>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </body>
</html>
