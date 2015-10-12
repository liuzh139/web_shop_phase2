<%-- 
    Document   : QuantityToBuy
    Created on : 24/09/2013, 4:45:48 PM
    Author     : liuzh139
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Quantity confirm</title>
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
   </head>
   <body>
      <div id="content">
         <%@include file="/WEB-INF/jspf/navigation.jspf" %>
         <h2>Confirm the quantity you want.</h2>
         <form action="/shopping/QuantityToBuyServlet" method="post">
            <fieldset>
               <legend>How many do you want to buy?</legend>
               <label>Quantity: <input type="text" name="quantity"/></label>
               <button type="submit">Buy</button>
            </fieldset>
         </form><br>
         <nav><cho><a href="/shopping/restricted/ViewProducts.jsp">Cancel</a></cho></nav>
      </div>
   </body>
</html>