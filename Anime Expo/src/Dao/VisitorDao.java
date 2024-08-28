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
import Connection.MySQLDataSource;
import Model.Visitor;
import java.sql.Date;

/**
 *
 * @author Juan Felipe Rubio
 */

public class VisitorDao {
    private MySQLDataSource conexion = new MySQLDataSource(); 
    
    public boolean insertVisitor(Visitor visitor){
        String sql = "INSERT INTO Visitors(name, id_number, gender, birth_date, email, phone_number, ticket_office_id) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try(Connection conn = conexion.conectarMySQL();
            PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setString(1, visitor.getName());
            stms.setString(2, visitor.getId_number());
            stms.setString(3, visitor.getGender());
            stms.setDate(4, new Date(visitor.getBirth_date().getTime()));
            stms.setString(5, visitor.getEmail());
            stms.setString(6, visitor.getPhone_number());
            stms.setInt(7, visitor.getTicket_office_id());
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
    }

    public Visitor viewVisitorId(int id){
        String sql = "SELECT * FROM Visitors WHERE visitor_id = ?";
        try(Connection conn = conexion.conectarMySQL();
            PreparedStatement stms = conn.prepareStatement(sql)){
            
            stms.setInt(1, id);
            
            ResultSet rs = stms.executeQuery();
            if (rs.next()){
                return new Visitor(
                    rs.getInt("visitor_id"),
                    rs.getString("name"),
                    rs.getString("id_number"),
                    rs.getString("gender"),
                    rs.getDate("birth_date"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getInt("ticket_office_id")
                );
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    
    public List<Visitor> viewVisitors(){
        List<Visitor> visitors = new ArrayList<>();
        try(Connection conn = conexion.conectarMySQL()){
            String sql = "SELECT * FROM Visitors";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()){
                Visitor visitor = new Visitor(
                    rs.getInt("visitor_id"),
                    rs.getString("name"),
                    rs.getString("id_number"),
                    rs.getString("gender"),
                    rs.getDate("birth_date"),
                    rs.getString("email"),
                    rs.getString("phone_number"),
                    rs.getInt("ticket_office_id")
                );
                visitors.add(visitor);
            }
            
        } catch(SQLException e){
            e.printStackTrace();
        }
        return visitors;
    }
}
