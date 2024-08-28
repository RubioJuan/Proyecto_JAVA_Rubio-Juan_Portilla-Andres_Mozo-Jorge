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
import Model.EventStaff;
import Connection.MySQLDataSource;
import java.sql.Date;
/**
 *
 * @author Juan Felipe Rubio
 */
public class EventStaffDao {
    private MySQLDataSource conexion = new MySQLDataSource();

    public boolean InsertEventSatff(EventStaff eventstaff){
        String sql = "INSERT INTO Event_Staff(name, id_number,birth_date, role, status, event_id) VALUES(?,?,?,?,?,?)";
        try(Connection conn = conexion.conectarMySQL();
            PreparedStatement stms = conn.prepareStatement(sql)) {
        
            stms.setString(1,eventstaff.getName());
            stms.setString(2,eventstaff.getId_number());
            stms.setDate(3,new Date(eventstaff.getBirth_date().getTime()));
            stms.setString(4,eventstaff.getRole());
            stms.setString(5,eventstaff.getStatus());
            stms.setInt(6,eventstaff.getEvent_id());
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }
    public EventStaff ViewEventStaffID(int id){
        String sql = "SELECT * FROM Event_Staff WHERE staff_id = ?";
        try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)){
            
            stms.setInt(1, id);
            
            ResultSet rs = stms.executeQuery();
            
            if (rs.next()){
               return new EventStaff(
                    rs.getInt("staff_id"), 
                    rs.getString("name"), 
                    rs.getString("id_number"), 
                    rs.getDate("birth_date"),
                    rs.getString("role"), 
                    rs.getString("status"), 
                    rs.getInt("event_id")
                );
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<EventStaff> ViewEvent(){
        List<EventStaff> event = new ArrayList<>();
        try(Connection conn = new MySQLDataSource().conectarMySQL()){
            String sql = "SELECT * FROM Event_Staff";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int staff_id = rs.getInt("EventID");
                String name = rs.getString("Name"); 
                String id_number = rs.getString("Country"); 
                Date birth_date = rs.getDate("City");
                String role = rs.getString("Address");
                String status = rs.getString("MaxPersonCapacity");
                int event_id = rs.getInt("MaxStoreCapacity");
                
                
                EventStaff eventstaffs = new EventStaff(staff_id, name, id_number, birth_date, role, 
                        status, event_id);
                event.add(eventstaffs);
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return event;
    }
}