package org.apache.jsp.restricted;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import dao.ProductJdbcDAO;
import domain.Product;
import domain.Product;
import java.util.Collection;
import java.util.*;
import dao.*;
import domain.*;

public final class ViewProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/WEB-INF/jspf/navigation.jspf");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("      <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("      <title>Product List</title>\r\n");
      out.write("      \r\n");
      out.write("      <link rel=\"stylesheet\" type=\"text/css\" href=\"/shopping/style.css\">\r\n");
      out.write("   </head>\r\n");
      out.write("   <body> <div id=\"content\">\r\n");
      out.write("      ");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("   <head>\n");
      out.write("      <link rel=\"stylesheet\" type=\"text/css\" href=\"/shopping/style.css\">\n");
      out.write("      <title>Navigation bar</title>\n");
      out.write("   </head>\n");
      out.write("\n");
      out.write("   <body>\n");
      out.write("      ");

         Customer cust = (Customer) session.getAttribute("customer");
      
      out.write("\n");
      out.write("      \n");
      out.write("      ");
 if (cust != null) {
      out.write("\n");
      out.write("      <h2> Hi, ");
      out.print(cust.getName());
      out.write(" </h2>\n");
      out.write("      <nav> \n");
      out.write("         <cho><a href=\"/shopping/index.jsp\">Home</a></cho>\n");
      out.write("         <cho><a href=\"/shopping/restricted/ViewProducts.jsp\">View Products</a></cho>\n");
      out.write("         <cho><a href=\"/shopping/restricted/CheckOut.jsp\">Shopping Cart</a></cho>\n");
      out.write("         <cho><a href=\"/shopping/LogoutServlet\">Log Out</a></cho>\n");
      out.write("\n");
      out.write("         ");
 } else {
      out.write("\n");
      out.write("        \n");
      out.write("         <nav> <cho><a href=\"/shopping/logIn.jsp\">Log In</a></cho>\n");
      out.write("         <cho><a href=\"/shopping/AddCustomer.jsp\">Create A New Account</a></cho>\n");
      out.write("\n");
      out.write("         ");
 }
      out.write("</nav>\n");
      out.write("   </body>\n");
      out.write("</html>");
      out.write("\r\n");
      out.write("      <h1>Product List</h1>\r\n");
      out.write("\r\n");
      out.write("      ");

      Collection <Product> products = new ProductJdbcDAO().getAll();
       
      out.write("\r\n");
      out.write("      <table border =\"1\">\r\n");
      out.write("      <thead>\r\n");
      out.write("         <tr>\r\n");
      out.write("            <th>ID</th>\r\n");
      out.write("            <th>Name</th>\r\n");
      out.write("            <th>Description</th>\r\n");
      out.write("            <th>Category</th>\r\n");
      out.write("            <th>Price</th>\r\n");
      out.write("            <th>Stock</th>\r\n");
      out.write("            <th></th>\r\n");
      out.write("         </tr>\r\n");
      out.write("      </thead>\r\n");
      out.write("\r\n");
      out.write("      <tbody>\r\n");
      out.write("         ");
 for (Product product : products) {
      out.write("\r\n");
      out.write("         <tr>\r\n");
      out.write("            <td> ");
      out.print( product.getId());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print( product.getName());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print( product.getDescription());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print( product.getCategory());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print( product.getPrice());
      out.write("</td>\r\n");
      out.write("            <td> ");
      out.print( product.getStock());
      out.write("</td>\r\n");
      out.write("      <td><form action =\"/shopping/BuyServlet\"><input type=\"hidden\" name=\"productId\" \r\n");
      out.write("                                                  value=\"");
      out.print(product.getId());
      out.write("\"><input class =\"buyBtn\" type =\"submit\" value =\"Buy\"></form></td>\r\n");
      out.write("         </tr>\r\n");
      out.write("         ");
 }
      out.write("\r\n");
      out.write("      </tbody>\r\n");
      out.write("   </table>\r\n");
      out.write("      <br>\r\n");
      out.write("      <br>\r\n");
      out.write("      <nav><cho> <a href=\"/shopping/restricted/CheckOut.jsp\">Check Out</a> </cho></nav>\r\n");
      out.write("      </div>\r\n");
      out.write("   </body>\r\n");
      out.write("</html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
