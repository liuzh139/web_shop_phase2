<%-- 
    Document   : InvalidInput
    Created on : Sep 26, 2013, 4:34:36 PM
    Author     : mark
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>Error Page: Invalid Input</title>
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
   </head>
   <body>
      <div><h2>Invalid Input</h2>
         <h2> <p><%=request.getAttribute("javax.servlet.error.message")%></p></h2>
         <nav><cho><a href="javascript:history.back()">Back</a></cho></nav>
      </div>
   </body>
</html>
