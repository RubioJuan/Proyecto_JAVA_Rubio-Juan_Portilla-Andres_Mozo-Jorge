/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//folder import
import Model.Order;
import connection.MySQLDataSource;
import java.math.BigDecimal;

/**
 *
 * @author Jorge Luis Mozo
 */
public class OrderDao {
    private MySQLDataSource conexion = new MySQLDataSource();
    
    public boolean InsertOrder (Order order) {
        String sql = " INSERT INTO Order (order_id, status, total_amount) VALUES (?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
              PreparedStatement stms = conn.prepareStatement(sql) ) {
            
            stms.setInt(1, order.getOrder_id());
            stms.setString (2, order.getStatus());
            stms.setBigDecimal (3, order.getTotal_amount());
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
            
    }
    public Order ViewOrderID(int id){
            String sql = "INSERT INTO Order(order_id, status, total_amount) VALUES(?, ?, ?)";

            try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)) {
                
                stms.setInt(1, id);
                
                ResultSet rs = stms.executeQuery();
                
                if (rs.next()) {
                    return new Order (
                            rs.getInt("register_id"),
                            rs.getString("status"),
                            rs.getBigDecimal("total_amount")
                    );
                }
            } catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }
    public List<Order> ViewOrder (){
            List<Order> orders = new ArrayList <>();
         String sql = "SELECT * FROM Order";
         try (Connection conn = conexion.conectarMySQL();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                 
             while (rs.next()) {
    Order order = new Order (
            rs.getInt("register_id"),
            rs.getString("status"),
            rs.getBigDecimal("total_amount")
    );
    orders.add(order);
}
         }catch (SQLException e) {
             e.printStackTrace();
         }
         return orders;
}
      public void updateOrder(Order order) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public void deleteOrder(int order_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}