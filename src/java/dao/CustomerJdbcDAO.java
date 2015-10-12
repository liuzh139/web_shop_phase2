/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author liuzh139
 */
public class CustomerJdbcDAO implements CustomerDAO {

   @Override
   public void save(Customer customer) {
      try (
              // get connection to database
              Connection connection = JdbcConnection.getConnection();
              // create the SQL statement
              PreparedStatement stmt = connection.prepareStatement(
                      "merge into customers (username, name, address, carddetails, password) values (?,?,?,?,?)");) {
         // copy the data from the product domain object into the statement
         stmt.setString(1, customer.getUsername());
         stmt.setString(2, customer.getName());
         stmt.setString(3, customer.getAddress());
         stmt.setString(4, customer.getCardDetails());
         stmt.setString(5, customer.getPassword());
         // execute the statement
         stmt.executeUpdate();
      } catch (SQLException ex) {
         throw new DAOException(ex.getMessage(), ex);
      }
   }

   @Override
   public Customer logIn(String username, String password) {
      Customer p = null;
      try {
         // get a connection to the database
         Connection connection = JdbcConnection.getConnection();
         // create the SQL statement
         PreparedStatement stmt =
                 connection.prepareStatement("select * from customers where username =? and password =?");
         // copy the data from the student domain object into the statement
         stmt.setString(1, username);
         stmt.setString(2, password);

         // execute the query
         ResultSet rs = stmt.executeQuery();
         // We are using a list in order to preserve the order in which
         // the data was returned from the SQL query.
         // iterate through the query results
         if (rs.next()) {

            // get the data out of the query
            String name = rs.getString("name");
            String address = rs.getString("address");
            String cardDetails = rs.getString("cardDetails");

            // use the data to create a student object
            p = new Customer(name, address, cardDetails, username, password);
         }
         stmt.close();
         rs.close();
         connection.close();
         
         System.out.println("ghjk:" + p);
         return p;
      } catch (SQLException ex) {
         throw new DAOException(ex.getMessage(), ex);
      }

   }

   @Override
   public Collection<Customer> getAll() {
      try {
         // get a connection to the database
         Connection connection = JdbcConnection.getConnection();
         // create the SQL statement
         PreparedStatement stmt =
                 connection.prepareStatement("select * from customers order by username");
         // execute the query
         ResultSet rs = stmt.executeQuery();
         // Create a collection for holding the student we get from the query.
         // We are using a list in order to preserve the order in which
         // the data was returned from the SQL query.
         Collection<Customer> customers = new ArrayList<>();
         // iterate through the query results
         while (rs.next()) {
            // get the data out of the query
            String name = rs.getString("name");
            String address = rs.getString("address");
            String cardDetails = rs.getString("cardDetails");
            String username = rs.getString("username");
            String password = rs.getString("password");
            // use the data to create a student object
            Customer s = new Customer(name, address, cardDetails, username, password);
            // and put it in the collection
            customers.add(s);
         }
         return customers;
      } catch (SQLException ex) {
         throw new DAOException(ex.getMessage(), ex);
      }
   }
}
