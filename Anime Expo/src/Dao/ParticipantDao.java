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
import Model.Participant;
import connection.MySQLDataSource;

/**
 *
 * @author Juan Felipe Rubio
 */

public class ParticipantDao {
   private MySQLDataSource conexion = new MySQLDataSource();

     public boolean InsertParticipant(Participant participant) {
        String sql = "INSERT INTO Participants(name,activity_id) VALUES(?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {

            stms.setString(1, participant.getName());
            stms.setInt(2, participant.getActivity_id());

            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    
    public Participant ViewParticipantID(int id){
        String sql = "SELECT * FROM Participants WHERE participant_id = ?";
        try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)){
            
            stms.setInt(1, id);
            
            ResultSet rs = stms.executeQuery();
            
            if (rs.next()){
                return new Participant(rs.getInt("participant_id"), rs.getString("Name"), rs.getInt("activity_id"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Participant> ViewParticipant(){
        List<Participant> participant = new ArrayList<>();
        try(Connection conn = new MySQLDataSource().conectarMySQL()){
            String sql = "SELECT * FROM Event";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int event_id = rs.getInt("participant_id");
                String name = rs.getString("Name"); 
                int activity_id = rs.getInt("activity_id");
                
                Participant participants = new Participant(event_id, name, activity_id);
                participant.add(participants);
            }
            
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        return participant;
        
    }
}
