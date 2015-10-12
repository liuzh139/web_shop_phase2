/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import domain.Customer;
import java.util.Collection;

/**
 *
 * @author liuzh139
 */
public interface CustomerDAO {
   void save(Customer customer);
   Customer logIn(String username, String password);
   Collection<Customer> getAll();
}
