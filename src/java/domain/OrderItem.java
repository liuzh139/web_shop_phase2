/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

/**
 *
 * @author liuzh139
 */
public class OrderItem {

   @NotNull(message = "Please enter the quantity you want.")
   @Range(min = 0, message = "Quantity cannot be negative.")
   private Double quantity;
   private Product product;

   public OrderItem(Double quantity, Product product) {
      this.quantity = quantity;
      this.product = product;
   }

   public Double getQuantity() {
      return quantity;
   }

   public void setQuantity(Double quantity) {
      this.quantity = quantity;
   }

   public Product getProduct() {
      return product;
   }

   public void setProduct(Product product) {
      this.product = product;
   }

   public double getItemTotal() {
      return product.getPrice() * quantity;
   }
}
