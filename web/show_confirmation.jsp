<%-- 
    Document   : ShowConfirmation
    Created on : Oct 21, 2023, 12:10:04 PM
    Author     : jiapat
--%>

<%@page import="model.ShoppingcartTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmed Page</title>
    </head>
    <%
        //ShoppingcartTable.removeAllShoppingcart();
    %>
    <body>
        <h1>Your Order is confirmed!</h1>
        <%
            double totalPrice = Double.parseDouble(request.getParameter("totalPrice"));
        %>
        <h1>The total amount is $<%= String.format("%.2f", totalPrice) %></h1>
    </body>
</html>
