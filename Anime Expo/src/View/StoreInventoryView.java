package View;

import Controller.StoreInventoryController;
import Dao.StoreInventoryDao;
import Model.StoreInventory;

import java.util.List;
import java.util.Scanner;

public class StoreInventoryView {
    private final Scanner scanner;
    private StoreInventoryController storeInventoryController;

    public StoreInventoryView(StoreInventoryController storeInventoryController) {
        this.scanner = new Scanner(System.in);
        this.storeInventoryController = storeInventoryController;
    }

    public void displayStoreInventoryList(List<StoreInventory> inventories) {
        System.out.println("Lista de Inventarios:");
        for (StoreInventory inventory : inventories) {
            System.out.println(inventory);
        }
    }

    public StoreInventory getNewStoreInventoryDetails() {
        System.out.println("Ingrese los detalles del producto:");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Descripción: ");
        String description = scanner.nextLine();
        System.out.print("Fabricante: ");
        String manufacturer = scanner.nextLine();
        System.out.print("Tipo: ");
        String type = scanner.nextLine();
        System.out.print("Cantidad: ");
        int quantity = scanner.nextInt();
        System.out.print("Precio: ");
        int price = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        return new StoreInventory(0, name, description, manufacturer, type, quantity, price);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Inventarios de Tiendas ---");
            System.out.println("1. Listar todos los productos");
            System.out.println("2. Crear un nuevo producto");
            System.out.println("3. Actualizar un producto");
            System.out.println("4. Eliminar un producto");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    storeInventoryController.listAllStoreInventories();
                    break;
                case 2:
                    StoreInventory newInventory = getNewStoreInventoryDetails();
                    storeInventoryController.createStoreInventory(newInventory);
                    break;
                case 3:
                    System.out.print("Ingrese el ID del producto a actualizar: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    StoreInventory updatedInventory = getNewStoreInventoryDetails();
                    updatedInventory.setInventory_id(updateId);
                    storeInventoryController.updateStoreInventory(updatedInventory);
                    break;
                case 4:
                    System.out.print("Ingrese el ID del producto a eliminar: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    storeInventoryController.deleteStoreInventory(deleteId);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 5);
    }
}
