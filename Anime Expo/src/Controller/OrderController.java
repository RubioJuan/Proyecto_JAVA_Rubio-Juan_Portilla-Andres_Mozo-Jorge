/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Order;
import Dao.OrderDao;
import java.util.List;

/**
 *
 * @author Jorge Luis Mozo 
 */
public class OrderController {
    
    private OrderDao orderDao;
    
    public OrderController() {
        this.orderDao = new OrderDao();
    }

    public void createOrder(Order order) {
        try {
            orderDao.InsertOrder(order); 
        } catch (Exception e) {
            System.err.println("Error al crear la orden: " + e.getMessage());
        }
    }

    public List<Order> getAllOrders() {
        try {
            return orderDao.ViewOrder();
        } catch (Exception e) {
            System.err.println("Error al obtener las ordenes: " + e.getMessage());
            return null;
        }
    }
     public void updateOrder(Order order) {
         try {
             orderDao.updateOrder(order);
         } catch (Exception e) {
             System.err.println("Error al actualizar la orden: " + e.getMessage());
         }
     }
     public void deleteOrder(int order_id) {
         try {
             orderDao.deleteOrder(order_id);
         } catch (Exception e) {
             System.err.println("Error al eliminar la orden: " + e.getMessage());
         }
     }
     public boolean isOrderIDExists(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
