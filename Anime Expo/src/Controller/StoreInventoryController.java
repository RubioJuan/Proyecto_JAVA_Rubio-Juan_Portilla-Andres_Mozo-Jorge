package Controller;

import Model.StoreInventory;
import Dao.StoreInventoryDao;
import View.StoreInventoryView;

import java.util.List;

public class StoreInventoryController {
    private StoreInventoryDao storeInventoryDao;
    private StoreInventoryView storeInventoryView;

    public StoreInventoryController(StoreInventoryDao storeInventoryDao, StoreInventoryView storeInventoryView) {
        this.storeInventoryDao = storeInventoryDao;
        this.storeInventoryView = storeInventoryView;
    }

    public void createStoreInventory(StoreInventory storeInventory) {
        if (storeInventoryDao.createStoreInventory(storeInventory)) {
            System.out.println("Producto creado exitosamente.");
        } else {
            System.out.println("Error al crear el producto.");
        }
    }

    public void listAllStoreInventories() {
        List<StoreInventory> inventories = storeInventoryDao.getAllStoresInventory();
        storeInventoryView.displayStoreInventoryList(inventories);
    }

    public void updateStoreInventory(StoreInventory storeInventory) {
        if (storeInventoryDao.updateStoreInventory(storeInventory)) {
            System.out.println("Producto actualizado exitosamente.");
        } else {
            System.out.println("Error al actualizar el producto.");
        }
    }

    public void deleteStoreInventory(int inventoryId) {
        if (storeInventoryDao.deleteStoreInventory(inventoryId)) {
            System.out.println("Producto eliminado exitosamente.");
        } else {
            System.out.println("Error al eliminar el producto.");
        }
    }

    public boolean isStoreNameExists(String name) {
        List<StoreInventory> inventories = storeInventoryDao.getAllStoresInventory();
        for (StoreInventory inventory : inventories) {
            if (inventory.getProduct_name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
