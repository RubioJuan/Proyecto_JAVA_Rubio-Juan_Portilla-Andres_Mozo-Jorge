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

// folder import
import Model.StoreInventory;
import connection.MySQLDataSource;

/**
 *
 * @author Juan Felipe Rubio
 */
public class StoreInventoryDao {

    public static void createStoreInventory(StoreInventory storeInventory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static List<StoreInventory> getAllStores_Inventorys() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   private MySQLDataSource conexion = new MySQLDataSource(); 
   
   public boolean InsertStoreInventory(StoreInventory storeInventory){
       String sql =  "INSERT INTO StoreInventory(inventory_id, product_name, description, manufacter, type, quantity, price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setInt(1, storeInventory.getInventory_id());
            stms.setString(2, storeInventory.getProduct_name());
            stms.setString(3, storeInventory.getDescription());
            stms.setString(4, storeInventory.getManufacter());
            stms.setString(5, storeInventory.getType());
            stms.setInt (6, storeInventory.getQuantity());
            stms.setInt (7, storeInventory.getPrice());
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; 
        } catch (SQLException e) {
            e.printStackTrace();
            return false; 
        }
        }
   
   public StoreInventory ViewStoreInventoryID(int id){
        String sql = "SELECT * FROM Events WHERE inventory_id = ?";
        try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)){
            
            stms.setInt(1, id);
            
            ResultSet rs = stms.executeQuery();
            
            if (rs.next()){
                return new StoreInventory (
                        rs.getInt("inventory_id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getString("manufacter"),
                        rs.getString("type"),
                        rs.getInt("quantity"),
                        rs.getInt ("price")
                );
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;   
   }
   public List<StoreInventory> ViewStore (){
         List<StoreInventory> storeInventorys = new ArrayList <>();
         String sql = "SELECT * FROM StoreInventory";
         try (Connection conn = conexion.conectarMySQL();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
             
             while (rs.next()) {
                 StoreInventory storeInventory = new StoreInventory (
                      rs.getInt("inventory_id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getString("manufacter"),
                        rs.getString("type"),
                        rs.getInt("quantity"),
                        rs.getInt ("price")
                ); 
                 storeInventorys.add(storeInventory);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return storeInventorys;
   }
   public void updateStoreInventory(StoreInventory storeInventory) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public void deleteStoreInventory(int inventory_Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
