/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Controller;

import Model.CashRegister;
import Dao.CashRegisterDao;
import java.util.List;

public class CashRegisterController {
    private CashRegisterDao cashRegisterDao;

    public CashRegisterController(CashRegisterDao cashRegisterDao) {
        this.cashRegisterDao = cashRegisterDao;
    }

    public void createCashRegister(CashRegister cashRegister) {
        try {
            if (cashRegisterDao.InsertCashRegister(cashRegister)) {
                System.out.println("Caja Registradora creada exitosamente.");
            } else {
                System.err.println("Error al crear la registradora.");
            }
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
            System.err.println("Error al eliminar la caja registradora: " + e.getMessage());
        }
    }

    public boolean isCashRegisterIdExists(int id) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
