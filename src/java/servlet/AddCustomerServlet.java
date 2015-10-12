/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import dao.CustomerJdbcDAO;
import domain.Customer;
import domain.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

/**
 *
 * @author liuzh139
 */
@WebServlet(name = "AddCustomerServlet", urlPatterns = {"/AddCustomerServlet"})
public class AddCustomerServlet extends HttpServlet {

   /**
    * Processes requests for both HTTP
    * <code>GET</code> and
    * <code>POST</code> methods.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      try {
         String username = request.getParameter("username");
         String name = request.getParameter("name");
         String address = request.getParameter("address");
         String cardDetails = request.getParameter("cardDetails");
         String password = request.getParameter("password");

         Customer customer = new Customer(name, address, cardDetails, username, password);
         
         // create the validator factory
         ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
         // get a validator from the factory
         Validator validator = factory.getValidator();
         // validate the student object
         Set<ConstraintViolation<Customer>> constraintViolations = validator.validate(customer);
         // check if any constraints were violated
         if (!constraintViolations.isEmpty()) {
            StringBuilder message = new StringBuilder();
            // loop through the violations extracting the message for each
            for (ConstraintViolation<Customer> violation : constraintViolations) {
               message.append(violation.getMessage()).append("<br>");
            }
            System.err.println("Validation error: "
                    + message);
            
            response.sendError(422, message.toString());
            
            // exit the save method, since the data is not valid
            //return;
         } else {
         
            new CustomerJdbcDAO().save(customer);
            response.sendRedirect("/shopping/");
         }
      } finally {
         out.close();
      }
   }

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   /**
    * Handles the HTTP
    * <code>GET</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   /**
    * Handles the HTTP
    * <code>POST</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      processRequest(request, response);
   }

   /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>
}
