/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.RestaurantMenu;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantMenuDao {
    private MySQLDataSource dataSource;

    public RestaurantMenuDao() {
        dataSource = new MySQLDataSource();
    }

    public boolean addDish(RestaurantMenu menu) {
        String sql = "INSERT INTO Restaurant_Menu (restaurant_id, dish_name, description, type, prep_time) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, menu.getRestaurantId());
            ps.setString(2, menu.getDishName());
            ps.setString(3, menu.getDescription());
            ps.setString(4, menu.getType());
            ps.setInt(5, menu.getPrepTime());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar el plato: " + e.getMessage());
        }
        return false;
    }

    public List<RestaurantMenu> getAllDishes(int restaurantId) {
        List<RestaurantMenu> dishes = new ArrayList<>();
        String sql = "SELECT * FROM Restaurant_Menu WHERE restaurant_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                RestaurantMenu menu = new RestaurantMenu(
                        rs.getInt("menu_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("dish_name"),
                        rs.getString("description"),
                        rs.getString("type"),
                        rs.getInt("prep_time")
                );
                dishes.add(menu);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los platos: " + e.getMessage());
        }
        return dishes;
    }

    public boolean updateDish(RestaurantMenu menu) {
        String sql = "UPDATE Restaurant_Menu SET dish_name = ?, description = ?, type = ?, prep_time = ? WHERE menu_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, menu.getDishName());
            ps.setString(2, menu.getDescription());
            ps.setString(3, menu.getType());
            ps.setInt(4, menu.getPrepTime());
            ps.setInt(5, menu.getMenuId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el plato: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteDish(int menuId) {
        String sql = "DELETE FROM Restaurant_Menu WHERE menu_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, menuId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar el plato: " + e.getMessage());
        }
        return false;
    }
}
