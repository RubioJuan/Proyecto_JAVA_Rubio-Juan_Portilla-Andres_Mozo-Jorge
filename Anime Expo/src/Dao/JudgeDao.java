/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.Judge;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JudgeDao {
    private MySQLDataSource dataSource;

    public JudgeDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<Judge> getAllJudges() {
        List<Judge> judges = new ArrayList<>();
        String query = "SELECT * FROM Judges";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Judge judge = new Judge(
                        rs.getInt("judge_id"),
                        rs.getString("name"),
                        rs.getString("id_number"),
                        rs.getDate("birth_date"),
                        rs.getString("email"),
                        rs.getString("phone_number"),
                        rs.getString("specialty"),
                        rs.getInt("event_id")
                );
                judges.add(judge);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return judges;
    }

    public void addJudge(Judge judge) {
        String query = "INSERT INTO Judges (name, id_number, birth_date, email, phone_number, specialty, event_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setString(1, judge.getName());
            pstmt.setString(2, judge.getIdNumber());
            pstmt.setDate(3, new java.sql.Date(judge.getBirthDate().getTime()));
            pstmt.setString(4, judge.getEmail());
            pstmt.setString(5, judge.getPhoneNumber());
            pstmt.setString(6, judge.getSpecialty());
            pstmt.setInt(7, judge.getEventId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
