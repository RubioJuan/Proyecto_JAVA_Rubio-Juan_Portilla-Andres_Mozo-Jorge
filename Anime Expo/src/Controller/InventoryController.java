/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Inventory;
import Dao.InventoryDao;
import java.util.List;

public class InventoryController {
    private InventoryDao inventoryDao;

    public InventoryController(InventoryDao inventoryDao) {
        this.inventoryDao = inventoryDao;
    }

    public void createInventory(Inventory inventory) {
        if (inventoryDao.InsertInventory(inventory)) {
            System.out.println("Inventario creado exitosamente.");
        } else {
            System.err.println("Error al crear el inventario.");
        }
    }

    public List<Inventory> getAllInventorys() {
        return inventoryDao.ViewInventory();
    }

    public Inventory getInventoryById(int id) {
        return inventoryDao.ViewInventoryID(id);
    }

    public void updateInventory(Inventory inventory) {
        inventoryDao.updateInventory(inventory);
    }

    public void deleteInventory(int inventory_id) {
        inventoryDao.deleteInventory(inventory_id);
    }

    public boolean isInventoryIDExists(int id) {
        return getInventoryById(id) != null;
    }
}
