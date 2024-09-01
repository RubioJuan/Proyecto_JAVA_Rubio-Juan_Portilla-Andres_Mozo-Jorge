package Dao;

import Model.Store;
import connection.MySQLDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StoreDao {
    private MySQLDataSource conexion = new MySQLDataSource();

    public boolean createStore(Store store) {
        String sql = "INSERT INTO Stores (name, description, manager) VALUES (?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, store.getName());
            stms.setString(2, store.getDescription());
            stms.setInt(3, store.getManager());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public Store getStoreById(int id) {
        String sql = "SELECT * FROM Stores WHERE store_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setInt(1, id);

            ResultSet rs = stms.executeQuery();

            if (rs.next()) {
                return new Store(
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

    public List<Store> getAllStores() {
        List<Store> stores = new ArrayList<>();
        String sql = "SELECT * FROM Stores";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Store store = new Store(
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

    public boolean updateStore(Store store) {
        String sql = "UPDATE Stores SET name = ?, description = ?, manager = ? WHERE store_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, store.getName());
            stms.setString(2, store.getDescription());
            stms.setInt(3, store.getManager());
            stms.setInt(4, store.getStore_id());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStore(int storeId) {
        String sql = "DELETE FROM Stores WHERE store_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setInt(1, storeId);

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
