/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.ActivityPrizeController;
import Dao.ActivityPrizeDao;
import Model.ActivityPrize;

import java.util.List;
import java.util.Scanner;

public class ActivityPrizeView {
    private final Scanner scanner;
    private ActivityPrizeController activityPrizeController;

    public ActivityPrizeView(ActivityPrizeController activityPrizeController) {
        this.scanner = new Scanner(System.in);
        this.activityPrizeController = activityPrizeController;
    }

    public void displayPrizeList(List<ActivityPrize> prizes) {
        System.out.println("Lista de Premios de Actividades:");
        for (ActivityPrize prize : prizes) {
            System.out.println(prize);
        }
    }

    public ActivityPrize getNewPrizeDetails() {
        System.out.println("Ingrese los detalles del nuevo premio:");
        System.out.println("Tipo: ");
        String type = scanner.nextLine();
        System.out.println("Descripción: ");
        String description = scanner.nextLine();
        System.out.println("Valor: ");
        double value = scanner.nextDouble();
        scanner.nextLine(); 
        System.out.println("Estado (available/delivered): ");
        String status = scanner.nextLine();
        System.out.println("ID de la actividad: ");
        int activityId = scanner.nextInt();
        System.out.println("ID del participante: ");
        int participantId = scanner.nextInt();
        scanner.nextLine(); 

        return new ActivityPrize(0, type, description, value, status, activityId, participantId);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Premios de Actividades ---");
            System.out.println("1. Listar todos los premios");
            System.out.println("2. Crear un nuevo premio");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    activityPrizeController.listAllPrizes();
                    break;
                case 2:
                    activityPrizeController.createNewPrize();
                    break;
                case 3:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (option != 3);
    }

    public static void main(String[] args) {
        ActivityPrizeDao activityPrizeDao = new ActivityPrizeDao();
        ActivityPrizeView activityPrizeView = new ActivityPrizeView(null); // Inicialmente nulo
        ActivityPrizeController activityPrizeController = new ActivityPrizeController(activityPrizeDao, activityPrizeView);

        // Asignar el controlador a la vista
        activityPrizeView.activityPrizeController = activityPrizeController;

        // Mostrar el menú
        activityPrizeView.showMenu();
    }
}

