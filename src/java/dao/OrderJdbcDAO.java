/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Order;
import domain.OrderItem;
import domain.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Collection;

/**
 *
 * @author liuzh139
 */
public class OrderJdbcDAO implements OrderDAO {

   @Override
   public void save(Order order) {

      Connection con = null;
      PreparedStatement insertOrderStmt = null;
      PreparedStatement insertOrderItemStmt = null;
      PreparedStatement updateProductStmt = null;

      try {
         con = JdbcConnection.getConnection();

         insertOrderStmt = con.prepareStatement(
                 "insert into orders (date, customer) values (?,?)",
                 Statement.RETURN_GENERATED_KEYS);

         insertOrderItemStmt = con.prepareStatement(
                 "insert into orderitems(productid, quantity, orderid) values(?,?,?)");

         updateProductStmt = con.prepareStatement(
                 "update products set stock = (?) where productId = (?)");

         // since saving and order involves multiple statements across
         // multiple tables we need to control the transaction ourselves
         // to ensure our DB remains consistent

         // turn off auto-commit which effectively starts a new transaction
         con.setAutoCommit(false);


         // -- save the order --

         // convert the order's java.util.Date into a java.sql.Timestamp
         Timestamp timestamp = new Timestamp(order.getOrderDate().getTime());

         // get the customer's username since it is the FK that links order and customer
         String username = order.getCustomer().getUsername();

         // ****
         // write code here that saves the timestamp and username in the order table
         // using the insertOrderStmt prepared statement
         // ****

         insertOrderStmt.setTimestamp(1, timestamp);
         insertOrderStmt.setString(2, username);
         insertOrderStmt.executeUpdate();

         // get the auto-generated order ID from the database
         ResultSet rs = insertOrderStmt.getGeneratedKeys();

         Integer orderId = null;

         if (rs.next()) {
            orderId = rs.getInt(1);
         } else {
            throw new DAOException("Problem getting generated Order ID");
         }

         // -- save the order items --

         Collection<OrderItem> items = order.getOrderItem();

         // ****
         // write code here that iterates through the order items and saves
         // them using the insertOrderItemStmt prepared statement.
         // ****
         for (OrderItem item : items) {
            insertOrderItemStmt.setInt(1, item.getProduct().getId());
            insertOrderItemStmt.setDouble(2, item.getQuantity());
            insertOrderItemStmt.setInt(3, orderId);
            insertOrderItemStmt.executeUpdate();
         }

         // -- update the product quantities --

         for (OrderItem item : items) {

            Product product = item.getProduct();

            // *******************************************************************
            // write code here that updates the product quantity using the
            // using the updateProductStmt prepared statement.
            // *******************************************************************
            updateProductStmt.setDouble(1, product.getStock() - item.getQuantity());
            updateProductStmt.setDouble(2, product.getId());
            updateProductStmt.executeUpdate();
         }


         // -- commit and clean-up --

         // commit the transaction
         con.commit();

         // turn auto-commit back on
         con.setAutoCommit(true);

         // close the statements and connection
         insertOrderStmt.close();
         insertOrderItemStmt.close();
         updateProductStmt.close();
         con.close();

      } catch (SQLException ex) {

         // something went wrong so rollback the entire transaction
         try {
            con.rollback();
         } catch (SQLException e) {
         }

         // and throw an exception to tell the user what happened
         throw new DAOException(ex.getMessage());
      }
   }
}
