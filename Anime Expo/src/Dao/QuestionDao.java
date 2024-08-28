/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDao {
    private MySQLDataSource dataSource;

    public QuestionDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<Question> getAllQuestions() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM Questions";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Question question = new Question(
                        rs.getInt("id_question"),
                        rs.getString("question"),
                        rs.getString("correct_answer"),
                        rs.getString("category"),
                        rs.getString("difficulty")
                );
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

    public void addQuestion(Question question) {
        String query = "INSERT INTO Questions (question, correct_answer, category, difficulty) VALUES (?, ?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, question.getQuestionText());
            pstmt.setString(2, question.getCorrectAnswer());
            pstmt.setString(3, question.getCategory());
            pstmt.setString(4, question.getDifficulty());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
