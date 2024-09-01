package View;

import Controller.StoreController;
import Dao.StoreDao;
import Model.Store;

import java.util.List;
import java.util.Scanner;

public class StoreView {
    private final Scanner scanner;
    private final StoreController storeController;

    public StoreView(StoreController storeController) {
        this.scanner = new Scanner(System.in);
        this.storeController = storeController;
    }

    public void displayScoreList(List<Store> stores) {
        System.out.println("Lista de Tiendas:");
        for (Store store : stores) {
            System.out.println(store);
        }
    }

    public Store getNewStoreDetails() {
        System.out.println("Ingrese los detalles de la nueva tienda:");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("ID del manager: ");
        int manager = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return new Store(0, name, description, manager);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Tiendas ---");
            System.out.println("1. Listar todas las tiendas");
            System.out.println("2. Crear una nueva tienda");
            System.out.println("3. Actualizar una tienda");
            System.out.println("4. Eliminar una tienda");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    storeController.listAllStores();
                    break;
                case 2:
                    Store newStore = getNewStoreDetails();
                    storeController.createStore(newStore);
                    break;
                case 3:
                    System.out.print("Ingrese el ID de la tienda a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    Store updatedStore = getNewStoreDetails();
                    updatedStore.setStore_id(updateId);
                    storeController.updateStore(updatedStore);
                    break;
                case 4:
                    System.out.print("Ingrese el ID de la tienda a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    storeController.deleteStore(deleteId);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    public static void main(String[] args) {
        StoreDao storeDao = new StoreDao();
        StoreView storeView = new StoreView(null); 
        StoreController storeController = new StoreController(storeDao, storeView);

        storeView = new StoreView(storeController); // Re-instanciado con el controlador correcto
        storeController = new StoreController(storeDao, storeView);

        storeView.showMenu();
    }
}
