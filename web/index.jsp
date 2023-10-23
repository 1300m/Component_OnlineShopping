<%-- 
    Document   : index
    Created on : Oct 21, 2023, 9:38:48 AM
    Author     : jiapat
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="model.Products"%>
<%@page import="model.ProductsTable"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Main Page</title>
    </head>
    <jsp:useBean id="product" class="model.Products" scope="request"/>
    <%
            List<Products> productList = ProductsTable.findAllProducts();
            Iterator<Products> itr = productList.iterator();
    %>
    <body>
        <center>
        <h1>DVD Catalog</h1>
        <form name="main" action="AddToShoppingCart" method="post">
            <table border="1">
                <tr>
                    <th>DVD Names</th>
                    <th>Rating</th>
                    <th>Year</th>
                    <th>Price</th>
                    <th>Quantity</th>
                </tr>
                <%     
                    while(itr.hasNext()) {
                        product = itr.next();
                %>
                <tr>
                    <td><input type="checkbox" name="movies" value="<%= product.getId() %>" />
                        <%= product.getMovie() %></td>
                    <td><%= product.getRating() %></td>
                    <td><%= product.getYearcreate() %></td>
                    <td><%= product.getPrice() %></td>
                    <td><input type="text" name="quantity" size="10" /></td>
                </tr>
                <%
                    }
                %>
            </table>
            <input type="submit" value="Add To Cart" name="submit" />
        </form>
        </center>
    </body>
</html>
