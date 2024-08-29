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

// folder import
import Model.Event;
import connection.MySQLDataSource;
import java.sql.Timestamp;

/**
 *
 * @author Juan Felipe Rubio
 */

public class EventDao {
       private MySQLDataSource conexion = new MySQLDataSource();

    public boolean InsertEvent(Event event) {
        String sql = "INSERT INTO Events(name, country, city, address, max_capacity, date_time, organizer, age_rating, status, min_age_with_guardian, min_age_without_guardian) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, event.getName());
            stms.setString(2, event.getCountry());
            stms.setString(3, event.getCity());
            stms.setString(4, event.getAddress());
            stms.setInt(5, event.getMax_capacity());
            stms.setTimestamp(6, new Timestamp(event.getDate_time().getTime()));
            stms.setString(7, event.getOrganizer());
            stms.setString(8, event.getAge_rating());
            stms.setString(9, event.getStatus());
            stms.setInt(10, event.getMin_age_with_guardian());
            stms.setInt(11, event.getMin_age_without_guardian());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    public Event ViewEventID(int id) {
        String sql = "SELECT * FROM Events WHERE event_id = ?";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setInt(1, id);

            ResultSet rs = stms.executeQuery();

            if (rs.next()) {
                return new Event(
                    rs.getInt("event_id"), 
                    rs.getString("name"), 
                    rs.getString("country"), 
                    rs.getString("city"), 
                    rs.getString("address"),
                    rs.getInt("max_capacity"), 
                    rs.getTimestamp("date_time"), 
                    rs.getString("organizer"), 
                    rs.getString("age_rating"),
                    rs.getString("status"), 
                    rs.getInt("min_age_with_guardian"), 
                    rs.getInt("min_age_without_guardian")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Event> ViewEvent() {
        List<Event> events = new ArrayList<>();
        String sql = "SELECT * FROM Events";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Event event = new Event(
                    rs.getInt("event_id"),
                    rs.getString("name"),
                    rs.getString("country"),
                    rs.getString("city"),
                    rs.getString("address"),
                    rs.getInt("max_capacity"),
                    rs.getTimestamp("date_time"),
                    rs.getString("organizer"),
                    rs.getString("age_rating"),
                    rs.getString("status"),
                    rs.getInt("min_age_with_guardian"),
                    rs.getInt("min_age_without_guardian")
                );
                events.add(event);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return events;
    }
}