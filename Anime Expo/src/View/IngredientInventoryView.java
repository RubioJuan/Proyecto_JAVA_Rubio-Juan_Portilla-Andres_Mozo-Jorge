/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.IngredientInventoryController;
import Model.IngredientInventory;

import java.util.List;
import java.util.Scanner;

public class IngredientInventoryView {
    private final IngredientInventoryController inventoryController;

    public IngredientInventoryView(IngredientInventoryController inventoryController) {
        this.inventoryController = inventoryController;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n*** Gestión del Inventario de Ingredientes ***");
            System.out.println("1. Agregar Ingrediente");
            System.out.println("2. Ver Todos los Ingredientes");
            System.out.println("3. Actualizar Ingrediente");
            System.out.println("4. Eliminar Ingrediente");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addIngredient(scanner);
                    break;
                case 2:
                    viewAllIngredients(scanner);
                    break;
                case 3:
                    updateIngredient(scanner);
                    break;
                case 4:
                    deleteIngredient(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        } while (option != 5);
    }

    private void addIngredient(Scanner scanner) {
        System.out.println("Introduce el ID del restaurante: ");
        int restaurantId = scanner.nextInt();
        System.out.println("Introduce el nombre del ingrediente: ");
        String ingredientName = scanner.next();
        System.out.println("Introduce la cantidad del ingrediente: ");
        int quantity = scanner.nextInt();
        if (inventoryController.addIngredient(restaurantId, ingredientName, quantity)) {
            System.out.println("Ingrediente agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el ingrediente.");
        }
    }

    private void viewAllIngredients(Scanner scanner) {
        System.out.println("Introduce el ID del restaurante para ver su inventario de ingredientes: ");
        int restaurantId = scanner.nextInt();
        List<IngredientInventory> ingredients = inventoryController.getAllIngredients(restaurantId);
        if (ingredients.isEmpty()) {
            System.out.println("No se encontraron ingredientes para este restaurante.");
        } else {
            System.out.println("Lista de Ingredientes:");
            for (IngredientInventory ingredient : ingredients) {
                System.out.println(ingredient);
            }
        }
    }

    private void updateIngredient(Scanner scanner) {
        System.out.println("Introduce el ID del ingrediente a actualizar: ");
        int ingredientId = scanner.nextInt();
        System.out.print("Introduce el nuevo nombre del ingrediente: ");
        String ingredientName = scanner.next();
        System.out.print("Introduce la nueva cantidad del ingrediente: ");
        int quantity = scanner.nextInt();
        if (inventoryController.updateIngredient(ingredientId, ingredientName, quantity)) {
            System.out.println("Ingrediente actualizado exitosamente.");
        } else {
            System.out.println("No se pudo actualizar el ingrediente.");
        }
    }

    private void deleteIngredient(Scanner scanner) {
        System.out.print("Introduce el ID del ingrediente a eliminar: ");
        int ingredientId = scanner.nextInt();
        if (inventoryController.deleteIngredient(ingredientId)) {
            System.out.println("Ingrediente eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el ingrediente.");
        }
    }

    public static void main(String[] args) {
        IngredientInventoryController controller = new IngredientInventoryController();
        IngredientInventoryView view = new IngredientInventoryView(controller);
        view.displayMenu();
    }
}
