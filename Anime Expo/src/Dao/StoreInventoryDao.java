package Dao;

import Model.StoreInventory;
import connection.MySQLDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreInventoryDao {
    private MySQLDataSource conexion = new MySQLDataSource();

    public boolean createStoreInventory(StoreInventory storeInventory) {
        String sql = "INSERT INTO Store_Inventory (product_name, description, manufacturer, type, quantity, price) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, storeInventory.getProduct_name());
            stms.setString(2, storeInventory.getDescription());
            stms.setString(3, storeInventory.getManufacturer());
            stms.setString(4, storeInventory.getType());
            stms.setInt(5, storeInventory.getQuantity());
            stms.setInt(6, storeInventory.getPrice());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<StoreInventory> getAllStoresInventory() {
        List<StoreInventory> inventories = new ArrayList<>();
        String sql = "SELECT * FROM Store_Inventory";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                StoreInventory inventory = new StoreInventory(
                        rs.getInt("inventory_id"),
                        rs.getString("product_name"),
                        rs.getString("description"),
                        rs.getString("manufacturer"),
                        rs.getString("type"),
                        rs.getInt("quantity"),
                        rs.getInt("price")
                );
                inventories.add(inventory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventories;
    }

    public boolean updateStoreInventory(StoreInventory storeInventory) {
        String sql = "UPDATE Store_Inventory SET product_name = ?, description = ?, manufacturer = ?, type = ?, quantity = ?, price = ? WHERE inventory_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, storeInventory.getProduct_name());
            stms.setString(2, storeInventory.getDescription());
            stms.setString(3, storeInventory.getManufacturer());
            stms.setString(4, storeInventory.getType());
            stms.setInt(5, storeInventory.getQuantity());
            stms.setInt(6, storeInventory.getPrice());
            stms.setInt(7, storeInventory.getInventory_id());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStoreInventory(int inventoryId) {
        String sql = "DELETE FROM Store_Inventory WHERE inventory_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setInt(1, inventoryId);

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
