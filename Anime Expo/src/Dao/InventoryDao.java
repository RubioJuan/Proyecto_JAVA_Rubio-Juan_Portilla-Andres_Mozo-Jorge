/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package Dao;

import Model.Inventory;
import connection.MySQLDataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InventoryDao {
    private MySQLDataSource conexion = new MySQLDataSource();
    
    public boolean InsertInventory(Inventory inventory) {
        String sql = "INSERT INTO Event_Inventory(name, quantity, status, event_id) VALUES(?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setString(1, inventory.getName());
            stms.setInt(2, inventory.getQuantity());
            stms.setString(3, inventory.getStatus());
            stms.setInt(4, inventory.getEventId());
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public Inventory ViewInventoryID(int id) {
        String sql = "SELECT * FROM Event_Inventory WHERE inventory_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setInt(1, id);
            ResultSet rs = stms.executeQuery();
            
            if (rs.next()) {
                return new Inventory(
                        rs.getInt("inventory_id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getString("status"),
                        rs.getInt("event_id")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Inventory> ViewInventory() {
        List<Inventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM Event_Inventory";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
             
            while (rs.next()) {
                Inventory inventory = new Inventory(
                        rs.getInt("inventory_id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getString("status"),
                        rs.getInt("event_id")
                );
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    public void updateInventory(Inventory inventory) {
        String sql = "UPDATE Event_Inventory SET name = ?, quantity = ?, status = ?, event_id = ? WHERE inventory_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setString(1, inventory.getName());
            stms.setInt(2, inventory.getQuantity());
            stms.setString(3, inventory.getStatus());
            stms.setInt(4, inventory.getEventId());
            stms.setInt(5, inventory.getInventory_id());
            
            stms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteInventory(int inventory_id) {
        String sql = "DELETE FROM Event_Inventory WHERE inventory_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setInt(1, inventory_id);
            stms.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
