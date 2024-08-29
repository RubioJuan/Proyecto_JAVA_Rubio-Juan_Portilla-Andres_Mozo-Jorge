/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ScoreController;
import Dao.ScoreDao;
import Model.Score;

import java.util.List;
import java.util.Scanner;

public class ScoreView {
    private final Scanner scanner;
    public ScoreController scoreController;

    public ScoreView(ScoreController scoreController) {
        this.scanner = new Scanner(System.in);
        this.scoreController = scoreController;
    }

    public void displayScoreList(List<Score> scores) {
        System.out.println("Lista de Puntuaciones:");
        for (Score score : scores) {
            System.out.println(score);
        }
    }

    public Score getNewScoreDetails() {
        System.out.println("Ingrese los detalles de la nueva puntuación:");
        System.out.print("ID del participante: ");
        int participantId = scanner.nextInt();
        System.out.print("ID de la actividad: ");
        int activityId = scanner.nextInt();
        System.out.print("Puntuación: ");
        double scoreValue = scanner.nextDouble();

        return new Score(0, participantId, activityId, scoreValue);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Puntuaciones ---");
            System.out.println("1. Listar todas las puntuaciones");
            System.out.println("2. Crear una nueva puntuación");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    scoreController.listAllScores();
                    break;
                case 2:
                    scoreController.createNewScore();
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
        ScoreDao scoreDao = new ScoreDao();
        ScoreView scoreView = new ScoreView(null); 
        ScoreController scoreController = new ScoreController(scoreDao, scoreView);

        scoreView.scoreController = scoreController;

        scoreView.showMenu();
    }
}
