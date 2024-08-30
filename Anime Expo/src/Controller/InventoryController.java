/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Inventory;
import Dao.InventoryDao;
import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */
public class InventoryController {
    private InventoryDao inventoryDao;
    
    public InventoryController(){
        this.inventoryDao = new InventoryDao();
    }
    public void createInventory(Inventory inventory) {
        try {
            inventoryDao.InsertInventory(inventory); 
        } catch (Exception e) {
            System.err.println("Error al crear el inventario: " + e.getMessage());
        }
    }
    public List<Inventory> getAllInventorys() {
        try {
            return inventoryDao.ViewInventory();
        } catch (Exception e) {
            System.err.println("Error al obtener los inventarios: " + e.getMessage());
            return null;
        }
    }
    public void updateInventory(Inventory inventory) {
         try {
             inventoryDao.updateInventory(inventory);
         } catch (Exception e) {
             System.err.println("Error al actualizar el inventario " + e.getMessage());
         }
     }
    public void deleteInventory(int inventary_id) {
         try {
             inventoryDao.deleteInventory(inventary_id);
         } catch (Exception e) {
             System.err.println("Error al eliminar el inventario: " + e.getMessage());
         }
     }
    public boolean isInventoryIDExists(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
