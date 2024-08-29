/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import connection.MySQLDataSource;
import Model.Report;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReportDao {
    private MySQLDataSource dataSource;

    public ReportDao() {
        this.dataSource = new MySQLDataSource();
    }

    public List<Report> getAllReports() {
        List<Report> reports = new ArrayList<>();
        String query = "SELECT * FROM Reports";
        try (Connection con = dataSource.conectarMySQL();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Report report = new Report(
                        rs.getInt("id_report"),
                        rs.getInt("id_event"),
                        rs.getString("report_type"),
                        rs.getString("content")
                );
                reports.add(report);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reports;
    }

    public void addReport(Report report) {
        String query = "INSERT INTO Reports (id_event, report_type, content) VALUES (?, ?, ?)";
        try (Connection con = dataSource.conectarMySQL();
             PreparedStatement pstmt = con.prepareStatement(query)) {
            pstmt.setInt(1, report.getEventId());
            pstmt.setString(2, report.getReportType());
            pstmt.setString(3, report.getContent());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
