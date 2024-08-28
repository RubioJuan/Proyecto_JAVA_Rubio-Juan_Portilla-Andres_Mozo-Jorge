/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.QuestionCategory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionCategoryDao {
    private MySQLDataSource dataSource;

    public QuestionCategoryDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<QuestionCategory> getAllCategories() {
        List<QuestionCategory> categories = new ArrayList<>();
        String query = "SELECT * FROM Question_Categories";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                QuestionCategory category = new QuestionCategory(
                        rs.getInt("id_question_category"),
                        rs.getString("category_name")
                );
                categories.add(category);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    public void addCategory(QuestionCategory category) {
        String query = "INSERT INTO Question_Categories (category_name) VALUES (?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, category.getCategoryName());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
