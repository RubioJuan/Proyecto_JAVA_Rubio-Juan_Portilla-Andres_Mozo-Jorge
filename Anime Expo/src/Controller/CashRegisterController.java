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
    
    public CashRegisterController(){
        this.cashRegisterDao = new CashRegisterDao();
    }
    public void createCashRegister (CashRegister cashRegister) {
        try {
            CashRegisterDao.createCashRegister(cashRegister);
        }catch (Exception e) {
            System.err.println("Error al crear la registradora " + e.getMessage());
        }
    }
    
    public List<CashRegister> getAllCashRegisters() {
         try {
             return CashRegisterDao.getAllCashRegisters();
         } catch (Exception e) {
             System.err.println("Error al obtener las registradoraslas tiendas: " + e.getMessage());
             return null;
         }
     }
}
