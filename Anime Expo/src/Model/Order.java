/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Juan Felipe Rubio
 */
public class Order {
  private int order_id;
  private String status;
  private BigDecimal total_amount;
  
  
  public Order (int order_id, String status, BigDecimal total_amount){
      this.order_id = order_id;
      this.status = status;
      this.total_amount = total_amount;
  }
  
  public int getOrder_id(){
      return order_id;
  }
  
  public void SetOrder_id (int order_id){
      this.order_id = order_id;
  }
  
  public String getStatus(){
      return status;
  }
  
  public void SetStatus (String status){
      this.status = status;
  }
  
  public BigDecimal getTotal_amount(){
      return total_amount;
  }
  
  public void SetTotal_amount(BigDecimal total_amount){
      this.total_amount = total_amount;
  }
}
