/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Connection.MySQLDataSource;
import Model.Restaurant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDao {
    private MySQLDataSource dataSource;

    public RestaurantDao() {
        dataSource = new MySQLDataSource();
    }

    public boolean addRestaurant(Restaurant restaurant) {
        String sql = "INSERT INTO Restaurants (name, manager) VALUES (?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, restaurant.getName());
            ps.setInt(2, restaurant.getManagerId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar el restaurante: " + e.getMessage());
        }
        return false;
    }

    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<>();
        String sql = "SELECT * FROM Restaurants";
        try (Connection con = dataSource.conectarMySQL();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Restaurant restaurant = new Restaurant(
                        rs.getInt("restaurant_id"),
                        rs.getString("name"),
                        rs.getInt("manager")
                );
                restaurants.add(restaurant);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los restaurantes: " + e.getMessage());
        }
        return restaurants;
    }

    public boolean updateRestaurant(Restaurant restaurant) {
        String sql = "UPDATE Restaurants SET name = ?, manager = ? WHERE restaurant_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, restaurant.getName());
            ps.setInt(2, restaurant.getManagerId());
            ps.setInt(3, restaurant.getRestaurantId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el restaurante: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteRestaurant(int restaurantId) {
        String sql = "DELETE FROM Restaurants WHERE restaurant_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, restaurantId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar el restaurante: " + e.getMessage());
        }
        return false;
    }
}
