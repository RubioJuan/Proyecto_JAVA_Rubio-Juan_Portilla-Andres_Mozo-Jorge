package View;

import Controller.RestaurantMenuController;
import Dao.RestaurantMenuDao;
import Model.RestaurantMenu;

import java.util.List;
import java.util.Scanner;

public class RestaurantMenuView {
    private RestaurantMenuController menuController;

    public RestaurantMenuView(RestaurantMenuController menuController) {
        this.menuController = menuController;
    }

    public void setMenuController(RestaurantMenuController menuController) {
        this.menuController = menuController;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n*** Gestión del Menú del Restaurante ***");
            System.out.println("1. Agregar Plato");
            System.out.println("2. Ver Todos los Platos");
            System.out.println("3. Actualizar Plato");
            System.out.println("4. Eliminar Plato");
            System.out.println("5. Salir");
            System.out.print("Elige una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addDish(scanner);
                    break;
                case 2:
                    viewAllDishes(scanner);
                    break;
                case 3:
                    updateDish(scanner);
                    break;
                case 4:
                    deleteDish(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida, por favor intenta de nuevo.");
            }
        } while (option != 5);
    }

    private void addDish(Scanner scanner) {
        System.out.print("Introduce el ID del restaurante: ");
        int restaurantId = scanner.nextInt();
        System.out.print("Introduce el nombre del plato: ");
        String dishName = scanner.next();
        System.out.print("Introduce la descripción del plato: ");
        String description = scanner.next();
        System.out.print("Introduce el tipo de plato (Appetizer, Drink, Main course, Dessert, Special combo, Meal): ");
        String type = scanner.next();
        System.out.print("Introduce el tiempo de preparación en minutos: ");
        int prepTime = scanner.nextInt();
        if (menuController.addDish(restaurantId, dishName, description, type, prepTime)) {
            System.out.println("Plato agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el plato.");
        }
    }

    private void viewAllDishes(Scanner scanner) {
        System.out.print("Introduce el ID del restaurante para ver sus platos: ");
        int restaurantId = scanner.nextInt();
        List<RestaurantMenu> dishes = menuController.getAllDishes(restaurantId);
        if (dishes.isEmpty()) {
            System.out.println("No se encontraron platos para este restaurante.");
        } else {
            System.out.println("Lista de Platos:");
            for (RestaurantMenu dish : dishes) {
                System.out.println(dish);
            }
        }
    }

    private void updateDish(Scanner scanner) {
        System.out.print("Introduce el ID del plato a actualizar: ");
        int menuId = scanner.nextInt();
        System.out.print("Introduce el nuevo nombre del plato: ");
        String dishName = scanner.next();
        System.out.print("Introduce la nueva descripción del plato: ");
        String description = scanner.next();
        System.out.print("Introduce el nuevo tipo de plato (Appetizer, Drink, Main course, Dessert, Special combo, Meal): ");
        String type = scanner.next();
        System.out.print("Introduce el nuevo tiempo de preparación en minutos: ");
        int prepTime = scanner.nextInt();
        if (menuController.updateDish(menuId, dishName, description, type, prepTime)) {
            System.out.println("Plato actualizado exitosamente.");
        } else {
            System.out.println("No se pudo actualizar el plato.");
        }
    }

    private void deleteDish(Scanner scanner) {
        System.out.print("Introduce el ID del plato a eliminar: ");
        int menuId = scanner.nextInt();
        if (menuController.deleteDish(menuId)) {
            System.out.println("Plato eliminado exitosamente.");
        } else {
            System.out.println("No se pudo eliminar el plato.");
        }
    }
}
