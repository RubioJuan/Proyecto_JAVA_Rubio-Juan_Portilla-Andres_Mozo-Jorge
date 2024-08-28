/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.QuestionController;
import Dao.QuestionDao;
import Model.Question;

import java.util.List;
import java.util.Scanner;

public class QuestionView {
    private final Scanner scanner;
    public QuestionController questionController;

    public QuestionView(QuestionController questionController) {
        this.scanner = new Scanner(System.in);
        this.questionController = questionController;
    }

    public void displayQuestionList(List<Question> questions) {
        System.out.println("Lista de Preguntas:");
        for (Question question : questions) {
            System.out.println(question);
        }
    }

    public Question getNewQuestionDetails() {
        System.out.println("Ingrese los detalles de la nueva pregunta:");
        System.out.print("Texto de la pregunta: ");
        String questionText = scanner.nextLine();
        System.out.print("Respuesta correcta: ");
        String correctAnswer = scanner.nextLine();
        System.out.print("Categoría: ");
        String category = scanner.nextLine();
        System.out.print("Dificultad (Easy, Intermediate, Hard): ");
        String difficulty = scanner.nextLine();
        return new Question(0, questionText, correctAnswer, category, difficulty);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Preguntas ---");
            System.out.println("1. Listar todas las preguntas");
            System.out.println("2. Crear una nueva pregunta");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    questionController.listAllQuestions();
                    break;
                case 2:
                    questionController.createNewQuestion();
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
        QuestionDao questionDao = new QuestionDao();
        QuestionView questionView = new QuestionView(null); // Inicialmente nulo
        QuestionController questionController = new QuestionController(questionDao, questionView);

        // Asignar el controlador a la vista
        questionView.questionController = questionController;

        // Mostrar el menú
        questionView.showMenu();
    }
}
