/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;


import Controller.ReportController;
import Dao.ReportDao;
import Model.Report;

import java.util.List;
import java.util.Scanner;

public class ReportView {
    private final Scanner scanner;
    public ReportController reportController;

    public ReportView(ReportController reportController) {
        this.scanner = new Scanner(System.in);
        this.reportController = reportController;
    }

    public void displayReportList(List<Report> reports) {
        System.out.println("Lista de Reportes:");
        for (Report report : reports) {
            System.out.println(report);
        }
    }

    public Report getNewReportDetails() {
        System.out.println("Ingrese los detalles del nuevo reporte:");
        System.out.println("ID del evento: ");
        int eventId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Tipo de reporte: ");
        String reportType = scanner.nextLine();
        System.out.println("Contenido del reporte: ");
        String content = scanner.nextLine();

        return new Report(0, eventId, reportType, content);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Reportes ---");
            System.out.println("1. Listar todos los reportes");
            System.out.println("2. Crear un nuevo reporte");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); 

            switch (option) {
                case 1:
                    reportController.listAllReports();
                    break;
                case 2:
                    reportController.createNewReport();
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
        ReportDao reportDao = new ReportDao();
        ReportView reportView = new ReportView(null); 
        ReportController reportController = new ReportController(reportDao, reportView);

        reportView.reportController = reportController;

        reportView.showMenu();
    }
}

