/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.RoundController;
import Dao.RoundDao;
import Model.Round;

import java.util.List;
import java.util.Scanner;

public class RoundView {
    private final Scanner scanner;
    public RoundController roundController;

    public RoundView(RoundController roundController) {
        this.scanner = new Scanner(System.in);
        this.roundController = roundController;
    }

    public void displayRoundList(List<Round> rounds) {
        System.out.println("Lista de Rondas:");
        for (Round round : rounds) {
            System.out.println(round);
        }
    }

    public Round getNewRoundDetails() {
        System.out.println("Ingrese los detalles de la nueva ronda:");
        System.out.print("ID del evento: ");
        int eventId = scanner.nextInt();
        System.out.print("Número de la ronda: ");
        int roundNumber = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer
        System.out.print("Descripción de la ronda: ");
        String description = scanner.nextLine();

        return new Round(0, eventId, roundNumber, description);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Rondas ---");
            System.out.println("1. Listar todas las rondas");
            System.out.println("2. Crear una nueva ronda");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    roundController.listAllRounds();
                    break;
                case 2:
                    roundController.createNewRound();
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
        RoundDao roundDao = new RoundDao();
        RoundView roundView = new RoundView(null); // Inicialmente nulo
        RoundController roundController = new RoundController(roundDao, roundView);

        // Asignar el controlador a la vista
        roundView.roundController = roundController;

        // Mostrar el menú
        roundView.showMenu();
    }
}
