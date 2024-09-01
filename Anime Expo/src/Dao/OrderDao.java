/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private List<Order> orders = new ArrayList<>();

    public void InsertOrder(Order order) {
        orders.add(order);
    }

    public List<Order> ViewOrder() {
        return orders;
    }

    public void updateOrder(Order order) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getId() == order.getId()) {
                orders.set(i, order);
                return;
            }
        }
    }

    public void deleteOrder(int order_id) {
        orders.removeIf(order -> order.getId() == order_id);
    }
}
