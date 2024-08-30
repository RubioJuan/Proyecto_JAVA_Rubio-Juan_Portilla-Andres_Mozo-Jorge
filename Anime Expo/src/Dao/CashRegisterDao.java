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

//Folder Import 
import Model.CashRegister;
import connection.MySQLDataSource;

/**
 *
 * @author Jorge Luis Mozo
 */
public class CashRegisterDao {
    private MySQLDataSource conexion = new MySQLDataSource();
    
    public boolean InsertCashRegister(CashRegister cashRegister) {
        String sql = "INSERT INTO CashRegister(register_id, status, opearator, openig_amount, closing_amount) VALUES(?, ?, ?, ?, ?)";
        try (Connection conn = conexion.conectarMySQL();
             PreparedStatement stms = conn.prepareStatement(sql)) {
            
            stms.setInt(1, cashRegister.getRegister_id());
            stms.setString(2, cashRegister.getStatus());
            stms.setInt(3, cashRegister.getOperator());
            stms.setBigDecimal(4, cashRegister.getOpening_amount());
            stms.setBigDecimal(5, cashRegister.getClosing_amount());
            
            int rowsAffected = stms.executeUpdate();
            return rowsAffected > 0; // Devuelve true si se insertaron filas, false si no
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Devuelve false si ocurre una excepción
        }
            
        }
    
        public CashRegister ViewCashRegisterID(int id){
            String sql = "INSERT INTO CashRegister(register_id, status, operator, opening_amount, closing_amount) VALUES(?, ?, ?, ?, ?)";

            try(Connection conn = new MySQLDataSource().conectarMySQL();
                PreparedStatement stms = conn.prepareStatement(sql)) {
                
                stms.setInt(1, id);
                
                ResultSet rs = stms.executeQuery();
                
                if (rs.next()) {
                    return new CashRegister (
                            rs.getInt("register_id"),
                            rs.getString("status"),
                            rs.getInt("operator"),
                            rs.getBigDecimal("opening_amount"),
                            rs.getBigDecimal("closing_amount")
                    );
                }
            } catch(SQLException e){
            e.printStackTrace();
        }
            return null;
    }
        public List<CashRegister> ViewCashRegister (){
            List<CashRegister> cashRegisters = new ArrayList <>();
         String sql = "SELECT * FROM CashRegister";
         try (Connection conn = conexion.conectarMySQL();
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {
                 
             while (rs.next()) {
    CashRegister cashRegister = new CashRegister (
            rs.getInt("register_id"),
            rs.getString("status"),
            rs.getInt("operator"),
            rs.getBigDecimal("opening_amount"),
            rs.getBigDecimal("closing_amount")
    );
    cashRegisters.add(cashRegister);
}
        }catch (SQLException e) {
             e.printStackTrace();
         }
         return cashRegisters;
}
        public void updateCashRegister(CashRegister cashRegister) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   public void deleteCashRegister(int resgister_id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}