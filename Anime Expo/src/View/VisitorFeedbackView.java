/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.VisitorFeedbackController;
import Model.VisitorFeedback;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */
public class VisitorFeedbackView {
    private VisitorFeedbackController visitorFeedbackController;

    // Constructor vacío
    public VisitorFeedbackView() {
    }

    // Método para asignar el controlador
    public void setVisitorFeedbackController(VisitorFeedbackController visitorFeedbackController) {
        this.visitorFeedbackController = visitorFeedbackController;
    }

    // Método para mostrar el menú e interactuar con el usuario
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese los datos del feedback del visitante:");

        boolean validEventId = false;
        int event_id = 0;
        while (!validEventId) {
            System.out.println("Ingrese el id del evento: ");
            try {
                event_id = Integer.parseInt(scanner.nextLine());
                if (visitorFeedbackController.isVisitorFeedbackExists(event_id)) {
                    System.out.println("Lamentablemente, ya existe un feedback para este evento. Por favor, ingrese un id de evento diferente.");
                } else {
                    validEventId = true;
                }
            } catch (NumberFormatException e) {
                System.out.println("Id del evento inválido. Por favor, ingrese un número entero.");
            }
        }

        System.out.println("Ingrese el id del visitante: ");
        int visitor_id = Integer.parseInt(scanner.nextLine());

        System.out.println("Ingrese el comentario: ");
        String comment = scanner.nextLine();

        System.out.println("Ingrese la calificación (1 a 5): ");
        int rating;
        try {
            rating = Integer.parseInt(scanner.nextLine());
            if (rating < 1 || rating > 5) {
                System.out.println("Calificación inválida. Debe ser un número entre 1 y 5.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Calificación inválida. Debe ser un número entero.");
            return;
        }

        VisitorFeedback visitorFeedback = new VisitorFeedback(
            0, event_id, visitor_id, comment, rating
        );

        if (visitorFeedbackController.AddVisitorFeedback(visitorFeedback)) {
            System.out.println("Feedback añadido exitosamente.");
        } else {
            System.out.println("No se pudo añadir el feedback.");
        }

        System.out.println("Lista de todos los feedbacks de visitantes:");
        visitorFeedbackController.getAllVisitorFeedback().forEach(System.out::println);

        scanner.close();
    }
}
