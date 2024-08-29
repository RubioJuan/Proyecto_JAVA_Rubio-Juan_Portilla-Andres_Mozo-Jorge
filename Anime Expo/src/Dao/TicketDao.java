/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;

// folder import
import Model.Ticket;
import connection.MySQLDataSource;

/**
 *
 * @author Juan Felipe Rubio
 */

public class TicketDao {
    private MySQLDataSource conexion = new MySQLDataSource();

     public boolean InsertTicket(Ticket ticket) {
        String sql = "INSERT INTO Ticket_Types(name, price, age_rating,additional_costs,status) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, ticket.getName());
            stms.setBigDecimal(2, ticket.getPrice());
            stms.setString(3, ticket.getAge_rating());
            stms.setBigDecimal(4, ticket.getAdditional_costs());
            stms.setString(5, ticket.getStatus());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    public Ticket ViewTicketID(int id) {
        String sql = "SELECT * FROM Ticket_Types WHERE ticket_type_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setInt(1, id);

            ResultSet rs = stms.executeQuery();

            if (rs.next()) {
                return new Ticket(
                    rs.getInt("ticket_type_id"),
                    rs.getString("name"),
                    rs.getBigDecimal("price"),
                    rs.getString("age_rating"),
                    rs.getBigDecimal("additional_costs"),
                    rs.getString("status")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Ticket> ViewTicket() {
    List<Ticket> tickets = new ArrayList<>();
    String sql = "SELECT * FROM Ticket_Types";
    try (Connection conn = conexion.conectarMySQL();
         PreparedStatement stmt = conn.prepareStatement(sql);
         ResultSet rs = stmt.executeQuery()) {

        while (rs.next()) {
            Ticket ticket = new Ticket(
                rs.getInt("ticket_type_id"),
                rs.getString("name"),
                rs.getBigDecimal("price"),
                rs.getString("age_rating"),
                rs.getBigDecimal("additional_costs"),
                rs.getString("status")
            );
            tickets.add(ticket);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return tickets;
    }
}