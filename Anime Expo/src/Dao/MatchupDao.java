/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.Matchup;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MatchupDao {
    private MySQLDataSource dataSource;

    public MatchupDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<Matchup> getAllMatchups() {
        List<Matchup> matchups = new ArrayList<>();
        String query = "SELECT * FROM Matchups";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Matchup matchup = new Matchup(
                        rs.getInt("id_matchup"),
                        rs.getInt("id_round"),
                        rs.getInt("id_participant1"),
                        rs.getInt("id_participant2"),
                        rs.getObject("winner", Integer.class)
                );
                matchups.add(matchup);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return matchups;
    }

    public void addMatchup(Matchup matchup) {
        String query = "INSERT INTO Matchups (id_round, id_participant1, id_participant2, winner) VALUES (?, ?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, matchup.getRoundId());
            pstmt.setInt(2, matchup.getParticipant1Id());
            pstmt.setInt(3, matchup.getParticipant2Id());
            pstmt.setObject(4, matchup.getWinnerId(), Types.INTEGER);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
