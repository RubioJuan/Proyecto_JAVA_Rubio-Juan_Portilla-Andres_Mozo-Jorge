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
import Model.VisitorFeedback;
import Connection.MySQLDataSource;
import java.sql.Date;

/**
 *
 * @author Juan Felipe Rubio
 */
public class VisitorFeedbackDao {
    private MySQLDataSource conexion = new MySQLDataSource();
    public boolean InsertVisitorFeedback(VisitorFeedback visitorfeedback) {
        String sql = "INSERT INTO Visitor_Feedback(event_id, visitor_id, comment, rating) VALUES(?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setInt(1,visitorfeedback.getEvent_id());
            stms.setInt(2,visitorfeedback.getVisitor_id());
            stms.setString(3, visitorfeedback.getComment());
            stms.setInt(4,visitorfeedback.getRating());
            
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }
    
    public VisitorFeedback ViewVisitorFeedbackId(int id){
        String sql = "SELECT * FROM Visitor_Feedback WHERE feedback_id = ?";
        try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)){
            
            stms.setInt(1, id);
            
            ResultSet rs = stms.executeQuery();
            
            if (rs.next()){
                return new VisitorFeedback(rs.getInt("feedback_id"), rs.getInt("event_id"), rs.getInt("visitor_id"), rs.getString("comment"),rs.getInt("rating"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<VisitorFeedback> ViewVisitorFeedback(){
        List<VisitorFeedback> visitorfeedback = new ArrayList<>();
        try(Connection conn = new MySQLDataSource().conectarMySQL()){
            String sql = "SELECT * FROM Visitor_Feedback";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                int feedback_id = rs.getInt("feedback_id");
                int event_id = rs.getInt("event_id"); 
                int visitor_id = rs.getInt("visitor_id"); 
                String comment = rs.getString("comment");
                int rating = rs.getInt("rating");
                
                VisitorFeedback visitorfeedbacks = new VisitorFeedback(feedback_id, event_id, visitor_id, comment, rating);
                visitorfeedback.add(visitorfeedbacks);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return visitorfeedback;
        
    }
}