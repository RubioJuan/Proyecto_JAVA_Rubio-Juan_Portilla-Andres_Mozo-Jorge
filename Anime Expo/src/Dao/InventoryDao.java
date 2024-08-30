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
import  Model.Inventory;
import Connection.MySQLDataSource;

/**
 *
 * @author Juan Felipe Rubio
 */
public class InventoryDao {
    private MySQLDataSource conexion = new MySQLDataSource();
    
    public boolean InsertInventory (Inventory inventory) {
      String sql = " INSERT INTO Inventory (inventory_id, name, quantity, status) VALUES (?, ?, ?, ?)";
      try (Connection conn = conexion.conectarMySQL();
              PreparedStatement stms = conn.prepareStatement(sql) ) {
          
          stms.setInt(1, inventory.getInventory_id());
          stms.setString(2, inventory.getName());
          stms.setInt(3, inventory.getQuantity());
          stms.setString(4, inventory.getStatus());
          
          int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
      
      }
    public Inventory ViewInventoryID (int id){
       String sql = "INSERT INTO Order(inventory_id, name, quantity, status) VALUES(?, ?, ?, ?)"; 
       
       try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)) {
           
          stms.setInt(1, id);
          
          ResultSet rs = stms.executeQuery();
          
          if (rs.next()) {
              return new Inventory (
                      rs.getInt("inventory_id"),
                      rs.getString("name"),
                      rs.getInt("Quantity"),
                      rs.getString("status")
              );
          }
       }catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }   
    public List<Inventory> ViewInventory (){
            List<Inventory> inventorys = new ArrayList <>();
         String sql = "SELECT * FROM Inventory";
         try (Connection conn = conexion.conectarMySQL();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                
             while (rs.next()) {
                 Inventory inventory = new Inventory (
                         rs.getInt("inventory_id"),
                         rs.getString("name"),
                         rs.getInt("quantity"),
                         rs.getString("status")
                 );
                 inventorys.add(inventory);
             }
                } catch (SQLException e) {
             e.printStackTrace();
         }
         return inventorys;
    }
    public void updateInventory(Inventory inventory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public void deleteInventory(int inventory_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
