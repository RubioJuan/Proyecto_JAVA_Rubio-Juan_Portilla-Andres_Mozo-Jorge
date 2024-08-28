/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Store;
import Dao.StoreDao;
import java.util.List;


/**
 *
 * @author Jorge Luis Mozo
 */
public class StoreController {
    private StoreDao storeDao;
    
    public StoreController(){
        this.storeDao =  new StoreDao();
    }
    
    public void createStore(Store store) {
        try {
            StoreDao.createStore(store);
        } catch (Exception e) {
            System.err.println("Error al crear la tienda: " + e.getMessage());
        }
    }
    
    public List<Store> getAllStores() {
         try {
             return StoreDao.getAllStores();
         } catch (Exception e) {
             System.err.println("Error al obtener las tiendas: " + e.getMessage());
             return null;
         }
     }
    
    public void updateStore(Store store) {
         try {
             storeDao.updateStore(store);
         } catch (Exception e) {
             System.err.println("Error al actualizar la tienda: " + e.getMessage());
         }
     }
    
    public void deleteStore(int store_id) {
         try {
             storeDao.deleteStore(store_id);
         } catch (Exception e) {
             System.err.println("Error al eliminar la tienda: " + e.getMessage());
         }
     }

    public boolean isStoreNameExists(String name) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
