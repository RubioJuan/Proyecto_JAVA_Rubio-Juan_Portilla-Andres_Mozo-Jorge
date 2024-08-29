/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.CosplayCategoryController;
import Dao.CosplayCategoryDao;
import Model.CosplayCategory;

import java.util.List;
import java.util.Scanner;

public class CosplayCategoryView {
    private final Scanner scanner;
    public CosplayCategoryController cosplayCategoryController;

    public CosplayCategoryView(CosplayCategoryController cosplayCategoryController) {
        this.scanner = new Scanner(System.in);
        this.cosplayCategoryController = cosplayCategoryController;
    }

    public void displayCategoryList(List<CosplayCategory> categories) {
        System.out.println("Lista de Categorías de Cosplay:");
        for (CosplayCategory category : categories) {
            System.out.println(category);
        }
    }

    public CosplayCategory getNewCategoryDetails() {
        System.out.println("Ingrese los detalles de la nueva categoría de cosplay:");
        System.out.println("Nombre de la categoría: ");
        String categoryName = scanner.nextLine();
        return new CosplayCategory(0, categoryName);
    }

    public void showMenu() {
        int option;
        do {
            System.out.println("\n--- Menú de Gestión de Categorías de Cosplay ---");
            System.out.println("1. Listar todas las categorías");
            System.out.println("2. Crear una nueva categoría");
            System.out.println("3. Salir");
            System.out.println("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (option) {
                case 1:
                    cosplayCategoryController.listAllCategories();
                    break;
                case 2:
                    cosplayCategoryController.createNewCategory();
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
        CosplayCategoryDao cosplayCategoryDao = new CosplayCategoryDao();
        CosplayCategoryView cosplayCategoryView = new CosplayCategoryView(null); // Inicialmente nulo
        CosplayCategoryController cosplayCategoryController = new CosplayCategoryController(cosplayCategoryDao, cosplayCategoryView);

        cosplayCategoryView.cosplayCategoryController = cosplayCategoryController;

        cosplayCategoryView.showMenu();
    }
}
