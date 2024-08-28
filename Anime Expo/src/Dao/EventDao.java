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
import java.sql.Date;

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
            stms.setDate(6, new Date(event.getDate_time().getTime()));
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

    
    public Event ViewEventID(int id){
        String sql = "SELECT * FROM Events WHERE event_id = ?";
        try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)){
            
            stms.setInt(1, id);
            
            ResultSet rs = stms.executeQuery();
            
            if (rs.next()){
                return new Event(rs.getInt("EventID"), rs.getString("Name"), rs.getString("Country"), rs.getString("City"), rs.getString("Address"),
                rs.getInt("max_capacity"), rs.getDate("date_time"), rs.getString("organizer"), rs.getString("age_rating"),
                rs.getString("Status"), rs.getInt("min_age_with_guardian"), rs.getInt("min_age_without_guardian"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Event> ViewEvent(){
        List<Event> event = new ArrayList<>();
        try(Connection conn = new MySQLDataSource().conectarMySQL()){
            String sql = "SELECT * FROM Event";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int event_id = rs.getInt("EventID");
                String name = rs.getString("Name"); 
                String country = rs.getString("Country"); 
                String city = rs.getString("City");
                String address = rs.getString("Address");
                int max_capacity = rs.getInt("MaxPersonCapacity");
                Date date_time = rs.getDate("MaxStoreCapacity");
                String organizer = rs.getString("MaxRestaurantCapacity");
                String age_rating = rs.getString("Date");
                String status = rs.getString("Time"); 
                int min_age_with_guardian = rs.getInt("Organizer");
                int min_age_without_guardian = rs.getInt("AgeRating"); 
                
                Event events = new Event(event_id, name, country, city, address, 
                        max_capacity, date_time, organizer, age_rating,
                        status, min_age_with_guardian, min_age_without_guardian);
                event.add(events);
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return event;
        
    }
}