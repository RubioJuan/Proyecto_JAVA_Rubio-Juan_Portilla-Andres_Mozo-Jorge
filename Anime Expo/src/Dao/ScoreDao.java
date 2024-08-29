/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.Score;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ScoreDao {
    private MySQLDataSource dataSource;

    public ScoreDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<Score> getAllScores() {
        List<Score> scores = new ArrayList<>();
        String query = "SELECT * FROM Scores";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Score score = new Score(
                        rs.getInt("id_score"),
                        rs.getInt("id_participant"),
                        rs.getInt("id_activity"),
                        rs.getDouble("score")
                );
                scores.add(score);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scores;
    }

    public void addScore(Score score) {
        String query = "INSERT INTO Scores (id_participant, id_activity, score) VALUES (?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, score.getParticipantId());
            pstmt.setInt(2, score.getActivityId());
            pstmt.setDouble(3, score.getScore());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos adicionales como updateScore, deleteScore, etc., pueden ser añadidos según los requerimientos.
}
