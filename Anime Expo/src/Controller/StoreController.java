package Controller;

import Model.Store;
import Dao.StoreDao;
import View.StoreView;

import java.util.List;

public class StoreController {
    private StoreDao storeDao;
    private StoreView storeView;

    public StoreController(StoreDao storeDao, StoreView storeView) {
        this.storeDao = storeDao;
        this.storeView = storeView;
    }

    public void createStore(Store store) {
        if (storeDao.createStore(store)) {
            System.out.println("Tienda creada exitosamente.");
        } else {
            System.out.println("Error al crear la tienda.");
        }
    }

    public void listAllStores() {
        List<Store> stores = storeDao.getAllStores();
        storeView.displayScoreList(stores);
    }

    public void updateStore(Store store) {
        if (storeDao.updateStore(store)) {
            System.out.println("Tienda actualizada exitosamente.");
        } else {
            System.out.println("Error al actualizar la tienda.");
        }
    }

    public void deleteStore(int storeId) {
        if (storeDao.deleteStore(storeId)) {
            System.out.println("Tienda eliminada exitosamente.");
        } else {
            System.out.println("Error al eliminar la tienda.");
        }
    }

    public boolean isStoreNameExists(String name) {
        List<Store> stores = storeDao.getAllStores();
        for (Store store : stores) {
            if (store.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
