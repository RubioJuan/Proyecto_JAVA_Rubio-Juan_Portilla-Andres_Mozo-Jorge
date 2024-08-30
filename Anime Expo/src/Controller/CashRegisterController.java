/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.CashRegister;
import Dao.CashRegisterDao;
import java.util.List;

/**
 *
 * @author Jorge Luis Mozo
 */
public class CashRegisterController {
    private CashRegisterDao cashRegisterDao;
    
    public CashRegisterController() {
        this.cashRegisterDao = new CashRegisterDao();
    }

    public void createCashRegister(CashRegister cashRegister) {
        try {
            cashRegisterDao.InsertCashRegister(cashRegister); 
        } catch (Exception e) {
            System.err.println("Error al crear la registradora: " + e.getMessage());
        }
    }

    public List<CashRegister> getAllCashRegisters() {
        try {
            return cashRegisterDao.ViewCashRegister();
        } catch (Exception e) {
            System.err.println("Error al obtener las registradoras: " + e.getMessage());
            return null;
        }
    }
     public void updateCashRegister(CashRegister cashRegister) {
         try {
             cashRegisterDao.updateCashRegister(cashRegister);
         } catch (Exception e) {
             System.err.println("Error al actualizar la caja registradora: " + e.getMessage());
         }
     }
     public void deleteCashRegister(int register_id) {
         try {
             cashRegisterDao.deleteCashRegister(register_id);
         } catch (Exception e) {
             System.err.println("Error al eliminar la tienda: " + e.getMessage());
         }
     }
     public boolean isCashRegisterIdExists(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

