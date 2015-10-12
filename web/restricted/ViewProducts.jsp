<%-- 
    Document   : ViewProducts
    Created on : 17/09/2013, 5:00:52 PM
    Author     : liuzh139
--%>

<%@page import="dao.ProductJdbcDAO"%>
<%@page import="domain.Product"%>
<%@page import="domain.Product"%>
<%@page import="java.util.Collection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Product List</title>
      
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
   </head>
   <body> <div id="content">
      <%@include file="/WEB-INF/jspf/navigation.jspf" %>
      <h1>Product List</h1>

      <%
      Collection<Product> products = new ProductJdbcDAO().getAll();
       %>
      <table border ="1">
      <thead>
         <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Description</th>
            <th>Category</th>
            <th>Price</th>
            <th>Stock</th>
            <th></th>
         </tr>
      </thead>

      <tbody>
         <% for (Product product : products) {%>
         <tr>
            <td> <%= product.getId()%></td>
            <td> <%= product.getName()%></td>
            <td> <%= product.getDescription()%></td>
            <td> <%= product.getCategory()%></td>
            <td> <%= product.getPrice()%></td>
            <td> <%= product.getStock()%></td>
      <td><form action ="/shopping/BuyServlet"><input type="hidden" name="productId" 
                                                  value="<%=product.getId()%>"><input class ="buyBtn" type ="submit" value ="Buy"></form></td>
         </tr>
         <% }%>
      </tbody>
   </table>
      <br>
      <br>
      <nav><cho> <a href="/shopping/restricted/CheckOut.jsp">Check Out</a> </cho></nav>
      </div>
   </body>
</html>


