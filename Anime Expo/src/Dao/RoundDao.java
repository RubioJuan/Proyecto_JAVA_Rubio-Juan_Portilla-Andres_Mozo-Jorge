/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.Round;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RoundDao {
    private MySQLDataSource dataSource;

    public RoundDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<Round> getAllRounds() {
        List<Round> rounds = new ArrayList<>();
        String query = "SELECT * FROM Rounds";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Round round = new Round(
                        rs.getInt("id_round"),
                        rs.getInt("id_event"),
                        rs.getInt("round_number"),
                        rs.getString("description")
                );
                rounds.add(round);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rounds;
    }

    public void addRound(Round round) {
        String query = "INSERT INTO Rounds (id_event, round_number, description) VALUES (?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, round.getEventId());
            pstmt.setInt(2, round.getRoundNumber());
            pstmt.setString(3, round.getDescription());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
