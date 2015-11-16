<!DOCTYPE html>
<html>
   <head><title>Login page</title>
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
   </head>
   <body>
      <%
         // get the status code to see why the log in page was requested
         Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
         // default message to display to the user
         String message = "Please log in to continue.";
         // if the status code was 401 (UNAUTHORIZED) then extract the message
         // from the request
         if (statusCode != null && statusCode == HttpServletResponse.SC_UNAUTHORIZED) {
            message = request.getAttribute("javax.servlet.error.message").toString();
         }
      %>
      <div id="content">
         <h2><p><%=message%></p></h2><!-- display the message to the user -->

         <h1>Login page</h1>
         <form action="/shopping/LogInServlet" method="post">
            <fieldset>
               <legend>Login details</legend>
               <label>Username:<input type="text" name="username"/></label>
               <label>Password:<input type="password" name="password"/></label>

               <button type="submit">Login</button>
            </fieldset>
         </form>
         <br>
         <br>
         <nav><cho><a href="/shopping">Go Back</a></cho></nav>
      </div>
   </body>
</html>