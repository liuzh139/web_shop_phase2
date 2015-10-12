<!DOCTYPE html>
<html>
   <head><title>Customer Management System</title>
      <link rel="stylesheet" type="text/css" href="/shopping/style.css">
   </head>
   <body>
      < <div id="content">
      <nav><h2>Let's create a new account!</h2></nav>

      <form action="/shopping/AddCustomerServlet" method="post">
         <fieldset>
            <legend>Account Details</legend>
            <label>User Name:<input type="text" name="username"/></label>
            <label>Name:<input type="text" name="name"/></label>
            <label>Address:<input type="text" name="address"/></label>
            <label>Credit Card:<input type="text" name="cardDetails"/></label>
            <label>Password:<input type="text" name="password"/></label>

            <button class="fancybutton" type="submit">Create account</button>
         </fieldset>
      </form>
      <br>
      <nav><cho><a href="/shopping">Go Back</a></cho></nav>
      </div>
   </body>
</html>