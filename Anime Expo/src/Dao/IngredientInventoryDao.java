/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import Connection.MySQLDataSource;
import Model.IngredientInventory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientInventoryDao {
    private MySQLDataSource dataSource;

    public IngredientInventoryDao() {
        dataSource = new MySQLDataSource();
    }

    public boolean addIngredient(IngredientInventory ingredient) {
        String sql = "INSERT INTO Ingredient_Inventory (restaurant_id, ingredient_name, quantity) VALUES (?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ingredient.getRestaurantId());
            ps.setString(2, ingredient.getIngredientName());
            ps.setInt(3, ingredient.getQuantity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al agregar el ingrediente: " + e.getMessage());
        }
        return false;
    }

    public List<IngredientInventory> getAllIngredients(int restaurantId) {
        List<IngredientInventory> ingredients = new ArrayList<>();
        String sql = "SELECT * FROM Ingredient_Inventory WHERE restaurant_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, restaurantId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                IngredientInventory ingredient = new IngredientInventory(
                        rs.getInt("ingredient_id"),
                        rs.getInt("restaurant_id"),
                        rs.getString("ingredient_name"),
                        rs.getInt("quantity")
                );
                ingredients.add(ingredient);
            }
        } catch (SQLException e) {
            System.err.println("Error al obtener los ingredientes: " + e.getMessage());
        }
        return ingredients;
    }

    public boolean updateIngredient(IngredientInventory ingredient) {
        String sql = "UPDATE Ingredient_Inventory SET ingredient_name = ?, quantity = ? WHERE ingredient_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, ingredient.getIngredientName());
            ps.setInt(2, ingredient.getQuantity());
            ps.setInt(3, ingredient.getIngredientId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al actualizar el ingrediente: " + e.getMessage());
        }
        return false;
    }

    public boolean deleteIngredient(int ingredientId) {
        String sql = "DELETE FROM Ingredient_Inventory WHERE ingredient_id = ?";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, ingredientId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.err.println("Error al eliminar el ingrediente: " + e.getMessage());
        }
        return false;
    }
}
