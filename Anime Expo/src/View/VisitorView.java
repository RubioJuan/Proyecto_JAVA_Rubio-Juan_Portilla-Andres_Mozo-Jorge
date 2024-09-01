/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package View;

import Controller.VisitorController;
import Model.Visitor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */

public class VisitorView {
    private VisitorController visitorController;

    // Constructor que acepta un controlador
    public VisitorView(VisitorController visitorController) {
        this.visitorController = visitorController;
    }

    // Método para asignar el controlador
    public void setVisitorController(VisitorController visitorController) {
        this.visitorController = visitorController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Ingrese los datos del visitante:");
        
        String name = "";
        boolean validName = false;
        while(!validName){
            System.out.println("Nombre del visitante: ");
            name = scanner.nextLine();
            
            if(visitorController.isVisitorNameExists(name)){
                System.out.println("Lastimosamente ya existe un visitante con este nombre, por favor ingrese un nombre diferente.");
            } else{
                validName = true;
            }
        }
        
        System.out.println("Numero de telefono: ");
        String id_number = scanner.nextLine();
        
        System.out.println("Ingrese el genero (Male, Female, Other): ");
        String gender = scanner.nextLine();
        
        System.out.println("Ingrese la fecha de nacimiento (yyyy-MM-dd): ");
        Date birth_date = null;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try {
            LocalDate localDate = LocalDate.parse(scanner.nextLine(), formatter);
            birth_date = java.sql.Date.valueOf(localDate);
        } catch (DateTimeParseException e) {
            System.out.println("Fecha inválida. Utilice el formato yyyy-MM-dd.");
            return; // Salir del método o repetir la entrada
        }
        
        System.out.println("Ingrese el Email: ");
        String email = scanner.nextLine();
        
        System.out.println("Ingrese el numero de telefono: ");
        String phone_number = scanner.nextLine();
        
        System.out.println("Ingrese el id del boleto: ");
        int ticket_office_id = Integer.parseInt(scanner.nextLine());
        
        Visitor visitor = new Visitor(
            0, name, id_number, gender, birth_date, email, phone_number, ticket_office_id
        );
        
        if(visitorController.addVisitor(visitor)){
            System.out.println("Visitante añadido exitosamente.");
        } else {
            System.out.println("No se pudo añadir el visitante.");
        }
        
        System.out.println("Lista de todos los visitantes:");
        visitorController.getAllVisitorss().forEach(System.out::println);
        
        scanner.close();
    }
}
