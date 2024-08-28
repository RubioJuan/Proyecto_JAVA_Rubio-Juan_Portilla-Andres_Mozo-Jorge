/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.QuestionCategoryController;
import Dao.QuestionCategoryDao;
import Model.QuestionCategory;

import java.util.List;
import java.util.Scanner;

public class QuestionCategoryView {
    private final Scanner scanner;
    public QuestionCategoryController categoryController;

    public QuestionCategoryView(QuestionCategoryController categoryController) {
        this.scanner = new Scanner(System.in);
        this.categoryController = categoryController;
    }

    public void displayCategoryList(List<QuestionCategory> categories) {
        System.out.println("Lista de Categorías de Preguntas:");
        for (QuestionCategory category : categories) {
            System.out.println(category);
        }
    }

    public QuestionCategory getNewCategoryDetails() {
        System.out.println("Ingrese los detalles de la nueva categoría:");
        System.out.println("Nombre de la categoría: ");
        String categoryName = scanner.nextLine();
        return new QuestionCategory(0, categoryName);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Categorías de Preguntas ---");
            System.out.println("1. Listar todas las categorías");
            System.out.println("2. Crear una nueva categoría");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    categoryController.listAllCategories();
                    break;
                case 2:
                    categoryController.createNewCategory();
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
        QuestionCategoryDao categoryDao = new QuestionCategoryDao();
        QuestionCategoryView categoryView = new QuestionCategoryView(null); 
        QuestionCategoryController categoryController = new QuestionCategoryController(categoryDao, categoryView);

        // Asignar el controlador a la vista
        categoryView.categoryController = categoryController;

        // Mostrar el menú
        categoryView.showMenu();
    }
}
