/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;


import connection.MySQLDataSource;
import Model.CosplayCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CosplayCategoryDao {
    private MySQLDataSource dataSource;

    public CosplayCategoryDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<CosplayCategory> getAllCategories() {
        List<CosplayCategory> categories = new ArrayList<>();
        String query = "SELECT * FROM Cosplay_Categories";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                CosplayCategory category = new CosplayCategory(
                        rs.getInt("id_category"),
                        rs.getString("category_name")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void addCategory(CosplayCategory category) {
        String query = "INSERT INTO Cosplay_Categories (category_name) VALUES (?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, category.getCategoryName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
