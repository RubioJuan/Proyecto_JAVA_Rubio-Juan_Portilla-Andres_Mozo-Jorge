/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import controller.ActivityController;
import model.Activity;

import java.util.List;
import java.util.Scanner;

public class ActivityView {

    private final ActivityController controller;
    private final Scanner scanner;

    public ActivityView() {
        this.controller = new ActivityController();
        this.scanner = new Scanner(System.in);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Gestión de Actividades ---");
            System.out.println("1. Crear Actividad");
            System.out.println("2. Ver Todas las Actividades");
            System.out.println("3. Actualizar Actividad");
            System.out.println("4. Eliminar Actividad");
            System.out.println("5. Salir");
            System.out.println("\n Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    createActivity();
                    break;
                case 2:
                    displayAllActivities();
                    break;
                case 3:
                    updateActivity();
                    break;
                case 4:
                    deleteActivity();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (option != 5);
    }

    private void createActivity() {
        System.out.println("Nombre de la actividad: ");
        String name = scanner.next();
        System.out.println("Tipo (Cosplay/Trivia): ");
        String type = scanner.next();
        System.out.println("Categoría: ");
        String category = scanner.next();
        System.out.println("Cantidad de participantes: ");
        int participantCount = scanner.nextInt();
        System.out.println("ID del evento: ");
        int eventId = scanner.nextInt();
        System.out.println("Hora de inicio (HH:MM:SS): ");
        String startTime = scanner.next();

        Activity activity = new Activity(0, name, type, category, participantCount, eventId, startTime);
        controller.createActivity(activity);
    }

    private void displayAllActivities() {
        List<Activity> activities = controller.getAllActivities();
        if (activities != null) {
            for (Activity activity : activities) {
                System.out.println(activity);
            }
        } else {
            System.out.println("No se pudieron obtener las actividades.");
        }
    }

    private void updateActivity() {
        System.out.print("ID de la actividad a actualizar: ");
        int activityId = scanner.nextInt();
        System.out.print("Nuevo nombre de la actividad: ");
        String name = scanner.next();
        System.out.print("Nuevo tipo (Cosplay/Trivia): ");
        String type = scanner.next();
        System.out.print("Nueva categoría: ");
        String category = scanner.next();
        System.out.print("Nueva cantidad de participantes: ");
        int participantCount = scanner.nextInt();
        System.out.print("Nuevo ID del evento: ");
        int eventId = scanner.nextInt();
        System.out.print("Nueva hora de inicio (HH:MM:SS): ");
        String startTime = scanner.next();

        Activity activity = new Activity(activityId, name, type, category, participantCount, eventId, startTime);
        controller.updateActivity(activity);
    }

    private void deleteActivity() {
        System.out.print("ID de la actividad a eliminar: ");
        int activityId = scanner.nextInt();
        controller.deleteActivity(activityId);
    }

    // Método main para ejecutar el menú
    public static void main(String[] args) {
        ActivityView activityView = new ActivityView();
        activityView.showMenu();
    }
}
