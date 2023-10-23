<%-- 
    Document   : shoppingcart
    Created on : Oct 21, 2023, 11:19:13 AM
    Author     : jiapat
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Shoppingcart"%>
<%@page import="model.ShoppingcartTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart Page</title>
    </head>
    <jsp:useBean id="cart" class="model.Shoppingcart" scope="request"/>
    <%           
            List<Shoppingcart> productList = ShoppingcartTable.findAllShoppingcart();
            Iterator<Shoppingcart> itr = productList.iterator();
    %>
    <body>
        <center>
        <h1>Shopping Cart</h1>
        <form name="main" action="show_confirmation.jsp" method="post">
            <table border="1">
                <tr>
                    <th>DVD Names</th>
                    <th>Rating</th>
                    <th>Year</th>
                    <th>Price/Unit</th>
                    <th>Quantity</th>
                    <th>Price</th>
                </tr>
                <%     
                    int totalPrice = 0;
                    while(itr.hasNext()) {
                        cart = itr.next();
                        out.println("<tr>");
                        out.println("<td> " + cart.getProducts().getMovie() + "</td>");
                        out.println("<td> " + cart.getProducts().getRating() + "</td>");
                        out.println("<td> " + cart.getProducts().getYearcreate() + "</td>");
                        out.println("<td> " + cart.getProducts().getPrice() + "</td>");
                        out.println("<td> " + cart.getQuantity() + "</td>");
                        int price = cart.getProducts().getPrice() * cart.getQuantity();
                        out.println("<td> " + price + "</td>");
                        out.println("</tr>");
                        totalPrice += price;
                    }
                    
                    request.setAttribute("totalPrice", totalPrice);
                %>
                <tr>
                    <td colspan="5" style="text-align: center;">Total</td>
                    <td><%= totalPrice %></td>
                </tr>
            </table>
            <input type="hidden" name="totalPrice" value="<%= totalPrice %>" />
            <input type="submit" value="Check out" name="submit" />
        </form>
        </center>
    </body>
</html>
