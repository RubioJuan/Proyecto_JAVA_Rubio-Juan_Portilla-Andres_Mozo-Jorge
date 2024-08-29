/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.JudgeController;
import Dao.JudgeDao;
import Model.Judge;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class JudgeView {
    private final Scanner scanner;
    public JudgeController judgeController;

    public JudgeView(JudgeController judgeController) {
        this.scanner = new Scanner(System.in);
        this.judgeController = judgeController;
    }

    public void displayJudgeList(List<Judge> judges) {
        System.out.println("Lista de Jueces:");
        for (Judge judge : judges) {
            System.out.println(judge);
        }
    }

    public Judge getNewJudgeDetails() {
        System.out.println("Ingrese los detalles del nuevo juez:");
        System.out.print("Nombre: ");
        String name = scanner.nextLine();
        System.out.print("Número de identificación: ");
        String idNumber = scanner.nextLine();
        System.out.print("Fecha de nacimiento (YYYY-MM-DD): ");
        Date birthDate = Date.valueOf(scanner.nextLine());
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();
        System.out.print("Número de teléfono: ");
        String phoneNumber = scanner.nextLine();
        System.out.print("Especialidad: ");
        String specialty = scanner.nextLine();
        System.out.print("ID del evento: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        return new Judge(0, name, idNumber, birthDate, email, phoneNumber, specialty, eventId);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Jueces ---");
            System.out.println("1. Listar todos los jueces");
            System.out.println("2. Crear un nuevo juez");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    judgeController.listAllJudges();
                    break;
                case 2:
                    judgeController.createNewJudge();
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
        JudgeDao judgeDao = new JudgeDao();
        JudgeView judgeView = new JudgeView(null); // Inicialmente nulo
        JudgeController judgeController = new JudgeController(judgeDao, judgeView);

        // Asignar el controlador a la vista
        judgeView.judgeController = judgeController;

        // Mostrar el menú
        judgeView.showMenu();
    }
}
