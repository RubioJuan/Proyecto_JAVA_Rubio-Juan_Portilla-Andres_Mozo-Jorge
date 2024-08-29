/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.StoreInventory;
import Dao.StoreInventoryDao;
import java.util.List;
/**
 *
 * @author Jorge Luis Mozo
 */
public class StoreInventoryController {
    private StoreInventoryDao storeInventoryDao;
    
    public StoreInventoryController(){
        this.storeInventoryDao =  new StoreInventoryDao();
    }
    public void createStore(StoreInventory storeInventory) {
        try {
            StoreInventoryDao.createStoreInventory(storeInventory);
        } catch (Exception e) {
            System.err.println("Error al crear el inventoario de la tienda: " + e.getMessage());
        }
    }
    
    public List<StoreInventory> getAllStores_Inventorys() {
         try {
             return StoreInventoryDao.getAllStores_Inventorys();
         } catch (Exception e) {
             System.err.println("Error al obtener los inventarios de las tiendas: " + e.getMessage());
             return null;
         }
     }
    
    public void updateStoreInventory(StoreInventory storeInventory) {
         try {
             storeInventoryDao.updateStoreInventory(storeInventory);
         } catch (Exception e) {
             System.err.println("Error al actualizar la tienda: " + e.getMessage());
         }
     }
    
    public void deleteStoreInventory(int inventory_id) {
         try {
             storeInventoryDao.deleteStoreInventory(inventory_id);
         } catch (Exception e) {
             System.err.println("Error al eliminar el inventario de la tienda: " + e.getMessage());
         }
     }
    
    public boolean isStoreNameExists(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
