/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package View;

import Controller.ActivityController;
import Dao.ActivityDao;
import Model.Activity;

import java.util.List;
import java.util.Scanner;

public class ActivityView {

    private final Scanner scanner;
    private  ActivityController activityController;

    public ActivityView(ActivityController activityController) {
        this.scanner = new Scanner(System.in);
        this.activityController = activityController;
    }

    public void displayActivityList(List<Activity> activities) {
        System.out.println("Lista de Actividades:");
        for (Activity activity : activities) {
            System.out.println(activity);
        }
    }

    public Activity getNewActivityDetails() {
        System.out.println("Ingrese los detalles de la nueva actividad:");
        System.out.println("Nombre: ");
        String name = scanner.nextLine();
        System.out.println("Tipo (Cosplay/Trivia): ");
        String type = scanner.nextLine();
        System.out.println("Categoría: ");
        String category = scanner.nextLine();
        System.out.println("Número de participantes: ");
        int participantCount = scanner.nextInt();
        System.out.println("ID del evento: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.println("Hora de inicio (HH:MM:SS): ");
        String startTime = scanner.nextLine();

        return new Activity(0, name, type, category, participantCount, eventId, startTime);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Actividades ---");
            System.out.println("1. Listar todas las actividades");
            System.out.println("2. Crear una nueva actividad");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    activityController.listAllActivities();
                    break;
                case 2:
                    activityController.createNewActivity();
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
    ActivityDao activityDao = new ActivityDao();
    ActivityView activityView = new ActivityView(null); // Inicialmente nulo
    ActivityController activityController = new ActivityController(activityDao, activityView);

    activityView = new ActivityView(activityController);

    activityView.showMenu();
}

}
