/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package View;

import Controller.InventoryController;
import Model.Inventory;
import java.util.Scanner;

public class InventoryView {
    private InventoryController controller;
    private Scanner scanner = new Scanner(System.in);

    public InventoryView(InventoryController controller) {
        this.controller = controller;
    }

    public void showMenu() {
        while (true) {
            System.out.println("1. Crear Inventario");
            System.out.println("2. Mostrar Inventarios");
            System.out.println("3. Actualizar Inventario");
            System.out.println("4. Eliminar Inventario");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            
            int option = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer
            
            switch (option) {
                case 1:
                    createInventory();
                    break;
                case 2:
                    listInventory();
                    break;
                case 3:
                    updateInventory();
                    break;
                case 4:
                    deleteInventory();
                    break;
                case 5:
                    return; // Salir
                default:
                    System.out.println("Opción inválida. Inténtalo de nuevo.");
            }
        }
    }

    private void createInventory() {
        System.out.print("Nombre del inventario: ");
        String name = scanner.nextLine();

        System.out.print("Cantidad: ");
        int quantity = scanner.nextInt();

        System.out.print("Estado ('In warehouse' / 'On site'): ");
        String status = scanner.next();
        
        System.out.print("ID del evento: ");
        int eventId = scanner.nextInt();
        
        Inventory inventory = new Inventory(0, name, quantity, status, eventId);
        controller.createInventory(inventory);
        
        System.out.println("Inventario creado exitosamente.");
    }

    private void listInventory() {
        for (Inventory inventory : controller.getAllInventorys()) {
            System.out.println("ID: " + inventory.getInventory_id() +
                               ", Nombre: " + inventory.getName() +
                               ", Cantidad: " + inventory.getQuantity() +
                               ", Estado: " + inventory.getStatus() +
                               ", ID del Evento: " + inventory.getEventId());
        }
    }

    private void updateInventory() {
        System.out.print("ID del inventario a actualizar: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        Inventory inventory = controller.getInventoryById(id);
        if (inventory == null) {
            System.out.println("Inventario no encontrado.");
            return;
        }

        System.out.print("Nuevo nombre (dejar vacío para no cambiar): ");
        String name = scanner.nextLine();
        if (!name.isEmpty()) {
            inventory.setName(name);
        }

        System.out.print("Nueva cantidad (dejar en blanco para no cambiar): ");
        String quantityInput = scanner.nextLine();
        if (!quantityInput.isEmpty()) {
            inventory.setQuantity(Integer.parseInt(quantityInput));
        }

        System.out.print("Nuevo estado ('In warehouse' / 'On site', dejar vacío para no cambiar): ");
        String status = scanner.nextLine();
        if (!status.isEmpty()) {
            inventory.setStatus(status);
        }
        
        System.out.print("Nuevo ID del evento (dejar vacío para no cambiar): ");
        String eventIdInput = scanner.nextLine();
        if (!eventIdInput.isEmpty()) {
            inventory.setEventId(Integer.parseInt(eventIdInput));
        }

        controller.updateInventory(inventory);
        System.out.println("Inventario actualizado exitosamente.");
    }

    private void deleteInventory() {
        System.out.print("ID del inventario a eliminar: ");
        int id = scanner.nextInt();
        controller.deleteInventory(id);
        System.out.println("Inventario eliminado exitosamente.");
    }
}
