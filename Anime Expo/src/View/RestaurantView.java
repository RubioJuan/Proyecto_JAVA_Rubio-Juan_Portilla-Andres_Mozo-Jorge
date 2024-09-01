/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.RestaurantController;
import Dao.RestaurantDao;
import Model.Restaurant;

import java.util.List;
import java.util.Scanner;

public class RestaurantView {
    private final RestaurantController restaurantController;

    public RestaurantView(RestaurantController restaurantController) {
        this.restaurantController = restaurantController;
    }

    public void displayMenu() {
        Scanner scanner = new Scanner(System.in);
        int option;
        do {
            System.out.println("\n***Gestion de Restaurante ***");
            System.out.println("1. Añador Restaurante");
            System.out.println("2. Ver todos los Restaurantes");
            System.out.println("3. Actualizar Restaurantes");
            System.out.println("4. Borrar restaurante");
            System.out.println("5. Salir");
            System.out.println("Selecciona una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    addRestaurant(scanner);
                    break;
                case 2:
                    viewAllRestaurants();
                    break;
                case 3:
                    updateRestaurant(scanner);
                    break;
                case 4:
                    deleteRestaurant(scanner);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción invalida,vuelve a intentarlo.");
            }
        } while (option != 5);
    }

    private void addRestaurant(Scanner scanner) {
        System.out.println("Ingresa el nombre de un restaurante: ");
        String name = scanner.next();
        System.out.print("Ingresa Id de Administrador: ");
        int managerId = scanner.nextInt();
        if (restaurantController.addRestaurant(name, managerId)) {
            System.out.println("Restaurante añadido de manera exitosa.");
        } else {
            System.out.println("Ups,Hubo un fallo...");
        }
    }

    private void viewAllRestaurants() {
        List<Restaurant> restaurants = restaurantController.getAllRestaurants();
        if (restaurants.isEmpty()) {
            System.out.println("Restaurante no encontrado.");
        } else {
            System.out.println("Lista de Restaurantes:");
            for (Restaurant restaurant : restaurants) {
                System.out.println(restaurant);
            }
        }
    }

    private void updateRestaurant(Scanner scanner) {
        System.out.println("Ingresa el Id del restaurante a Modificar: ");
        int restaurantId = scanner.nextInt();
        System.out.println("Ingresa el nuevo nombre al restaurante: ");
        String name = scanner.next();
        System.out.println("Ingresa el id del nuevo administrador: ");
        int managerId = scanner.nextInt();
        if (restaurantController.updateRestaurant(restaurantId, name, managerId)) {
            System.out.println("Restaurante actualizado con exitoso.");
        } else {
            System.out.println("Upss.No fue posible añadir el restaurant.");
        }
    }

    private void deleteRestaurant(Scanner scanner) {
        System.out.println("Ingresa el id del restaurante a eliminar: ");
        int restaurantId = scanner.nextInt();
        if (restaurantController.deleteRestaurant(restaurantId)) {
            System.out.println("Restaurante eliminado con exito.");
        } else {
            System.out.println("No se pudo eliminar el resaurante.");
        }
    }

    public static void main(String[] args) {
        RestaurantDao restaurantDao = new RestaurantDao();
        RestaurantController controller = new RestaurantController(restaurantDao);
        RestaurantView view = new RestaurantView(controller);
        view.displayMenu();
    }
}
