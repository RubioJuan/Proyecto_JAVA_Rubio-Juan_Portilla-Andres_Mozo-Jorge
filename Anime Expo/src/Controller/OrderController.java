package Controller;

import Model.Order;
import Dao.OrderDao;
import java.util.List;

public class OrderController {
    private OrderDao orderDao;

    // Constructor que acepta un OrderDao
    public OrderController(OrderDao orderDao) {
        this.orderDao = orderDao;
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
}
