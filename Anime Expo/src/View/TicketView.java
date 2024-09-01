/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package View;

import Controller.TicketController;
import Model.Ticket;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */

public class TicketView {
    private TicketController ticketController;

    // Constructor que acepta un controlador
    public TicketView(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    // Método para asignar el controlador
    public void setTicketController(TicketController ticketController) {
        this.ticketController = ticketController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Obtener ticket:");
        
        // Validar el nombre del participante
        String name = "";
        boolean validName = false;
        while (!validName) {
            System.out.println("Nombre del visitante: ");
            name = scanner.nextLine();
            
            if (ticketController.isEventNameExists(name)) {
                System.out.println("Lamentablemente ya existe un visitante con este nombre, por favor ingrese un nombre diferente.");
            } else {
                validName = true;
            }
        }
        
        // Leer y validar el precio
        System.out.println("Ingrese el precio: ");
        BigDecimal price;
        while (true) {
            try {
                price = new BigDecimal(scanner.nextLine());
                break; // Salir del bucle si la conversión es exitosa
            } catch (NumberFormatException e) {
                System.out.println("Precio inválido. Por favor, ingrese un número válido.");
            }
        }
        
        // Leer y validar el rating
        System.out.println("Ingrese el rating de edad: ");
        String age_rating = scanner.nextLine();
        
        // Leer y validar los costos adicionales
        System.out.println("Ingrese los costos adicionales: ");
        BigDecimal additional_costs;
        while (true) {
            try {
                additional_costs = new BigDecimal(scanner.nextLine());
                break; // Salir del bucle si la conversión es exitosa
            } catch (NumberFormatException e) {
                System.out.println("Costo adicional inválido. Por favor, ingrese un número válido.");
            }
        }
        
        // Leer el estado
        System.out.println("Ingrese el estado (Paid, Reserved): ");
        String status = scanner.nextLine();
        
        // Crear el objeto Ticket
        Ticket ticket = new Ticket(
            0, name, price, age_rating, additional_costs, status
        );
        
        // Añadir el participante
        if (ticketController.AddEventStaff(ticket)) {
            System.out.println("Ticket obtenido exitosamente.");
        } else {
            System.out.println("No se pudo obtener el ticket.");
        }
        
        // Mostrar la lista de participantes
        System.out.println("Lista de todos los tickets:");
        ticketController.getAllEventsStaff().forEach(System.out::println);
        
        // Cerrar el escáner
        scanner.close();
    }
}
