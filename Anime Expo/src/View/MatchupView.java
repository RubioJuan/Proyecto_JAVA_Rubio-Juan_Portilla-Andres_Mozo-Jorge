/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.MatchupController;
import Dao.MatchupDao;
import Model.Matchup;

import java.util.List;
import java.util.Scanner;

public class MatchupView {
    private final Scanner scanner;
    public MatchupController matchupController;

    public MatchupView(MatchupController matchupController) {
        this.scanner = new Scanner(System.in);
        this.matchupController = matchupController;
    }

    public void displayMatchupList(List<Matchup> matchups) {
        System.out.println("Lista de Enfrentamientos:");
        for (Matchup matchup : matchups) {
            System.out.println(matchup);
        }
    }

    public Matchup getNewMatchupDetails() {
        System.out.println("Ingrese los detalles del nuevo enfrentamiento:");
        System.out.println("ID de la ronda: ");
        int roundId = scanner.nextInt();
        System.out.println("ID del primer participante: ");
        int participant1Id = scanner.nextInt();
        System.out.println("ID del segundo participante: ");
        int participant2Id = scanner.nextInt();
        System.out.println("ID del ganador (dejar vacío si aún no hay ganador): ");
        Integer winnerId = scanner.nextInt();
        scanner.nextLine(); 

        return new Matchup(0, roundId, participant1Id, participant2Id, winnerId == 0 ? null : winnerId);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Enfrentamientos ---");
            System.out.println("1. Listar todos los enfrentamientos");
            System.out.println("2. Crear un nuevo enfrentamiento");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    matchupController.listAllMatchups();
                    break;
                case 2:
                    matchupController.createNewMatchup();
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
        MatchupDao matchupDao = new MatchupDao();
        MatchupView matchupView = new MatchupView(null);
        MatchupController matchupController = new MatchupController(matchupDao, matchupView);

        matchupView.matchupController = matchupController;

        matchupView.showMenu();
    }
}
