/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author liuzh139
 */
public class Customer {

   @NotBlank(message = "Name must be provided!")
   @Length(min = 2, message = "Name must contain at least two characters.")
   private String name;
   
   @NotBlank(message = "Please provide an address!")
   @Length(min = 5, message = "Please provide a valid address!")
   private String address;
   
   @NotBlank(message = "Credit card details must be provided!")
   private String cardDetails;
   
   @NotBlank(message = "You must have a username to login!")
   @Length(min = 2, message = "Username must contain at least two characters.")
   private String username;
   
   @NotBlank(message = "You must set up a password!")
   @Length(min = 3, message = "Password cannot be less than 3 characters.")
   private String password;

   public Customer(String name, String address, String cardDetails, String username, String password) {
      this.name = name;
      this.address = address;
      this.cardDetails = cardDetails;
      this.username = username;
      this.password = password;
   }

   public String getName() {
      return name;
   }

   public String getAddress() {
      return address;
   }

   public String getCardDetails() {
      return cardDetails;
   }

   public String getUsername() {
      return username;
   }

   public String getPassword() {
      return password;
   }

   public void setName(String name) {
      this.name = name;
   }

   public void setAddress(String address) {
      this.address = address;
   }

   public void setCardDetails(String cardDetails) {
      this.cardDetails = cardDetails;
   }

   public void setUsername(String username) {
      this.username = username;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   @Override
   public String toString() {
      return "Customer{" + "name=" + name + ", address=" + address + ", cardDetails=" + cardDetails + ", username=" + username + '}';
   }
}
