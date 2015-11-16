<%-- 
    Document   : CheckOut
    Created on : 24/09/2013, 5:51:50 PM
    Author     : liuzh139
--%>

<%@page import="domain.OrderItem"%>
<%@page import="java.util.Collection"%>
<%@page import="java.util.Collection"%>
<%@page import="domain.Order"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Check out</title>
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
   </head>
   <body>
      <%@include file="/WEB-INF/jspf/navigation.jspf" %>
      <h1>Check Out</h1>

      <%
         // get order from session
         Order order = (Order) session.getAttribute("order");
         Collection<OrderItem> items = order.getOrderItem();
      %>
      <table border ="1">
         <thead>
            <tr>
               <th>Product</th>
               <th>Price</th>
               <th>Quantity</th>

            </tr>
         </thead>

         <tbody>
            <% for (OrderItem item : items) {%>
            <tr>

               <td> <%= item.getProduct().getName()%></td>
               <td> <%= item.getProduct().getPrice()%></td>
               <td> <%= item.getQuantity()%></td>

            </tr>
            <% }%>
         </tbody>   
      </table>

         <br>
         <nav><td><form action ="/shopping/CheckOutServlet"><input type ="submit" value ="Confirm Order"></form></td></nav>
</body>
</html>
