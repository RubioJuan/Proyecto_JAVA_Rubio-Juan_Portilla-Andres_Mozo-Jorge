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
import Model.Store;
import Connection.MySQLDataSource;
import Connection.MySQLDataSource;
import java.sql.Timestamp;

/**
 *
 * @author Jorge Luis Mozo
 */
public class StoreDao {

    public static List<Store> getAllStores() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void createStore(Store store) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
     private MySQLDataSource conexion = new MySQLDataSource();
     
     public boolean InsertStore (Store store) {
         String sql = "INSERT INTO Store (store_id, name, description, manager) VALUES (?, ?, ?, ?) ";
         try (Connection conn = conexion.conectarMySQL();
               PreparedStatement stms = conn.prepareStatement(sql)){
                
             stms.setInt (1, store.getStore_id());
             stms.setString(2,store.getName());
             stms.setString(3, store.getDescription());
             stms.setInt(4, store.getManager());
             
             int rowsAffected = stms.executeUpdate();
             return rowsAffected > 0;  
         } catch (SQLException e){
             e.printStackTrace();
             return false;
         }
     }
     
     public Store ViewStoreID (int id){
         String sql= "SELECT * FROM Store WHERE store_id = ?";
         try (Connection conn = conexion.conectarMySQL();
                 PreparedStatement stms = conn.prepareStatement(sql)){
             
             stms. setInt(1, id);
                     
             ResultSet rs = stms.executeQuery();
             
             if (rs.next()) {
                 return new Store (
                      rs.getInt("store_id"),
                      rs.getString("name"),
                      rs.getString("description"),
                      rs.getInt("manager")
                 );
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return null;
     }
     
     public List<Store> ViewStore (){
         List<Store> stores = new ArrayList <>();
         String sql = "SELECT * FROM Store";
         try (Connection conn = conexion.conectarMySQL();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                 
             while (rs.next()) {
                 Store store = new Store (
                   rs.getInt("store_id"),
                      rs.getString("name"),
                      rs.getString("description"),
                      rs.getInt("manager")
                 );
                 stores.add(store);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return stores;
     }

    public void updateStore(Store store) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void deleteStore(int store_Id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
