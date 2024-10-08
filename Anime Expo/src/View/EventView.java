/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package View;

import Controller.EventController;
import Model.Event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */

public class EventView {
    private EventController eventController; // Referencia al controlador

    // Método para asignar el controlador
    public void setEventController(EventController eventController) {
        this.eventController = eventController;
    }

    // Método para mostrar el menú e interactuar con el usuario
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm");

        System.out.println("Ingrese los detalles del evento:");

        String name = "";
        boolean validName = false;
        while (!validName) {
            System.out.print("Nombre del Evento: ");
            name = scanner.nextLine();

            if (eventController.isEventNameExists(name)) {
                System.out.println("Ya existe un evento con este nombre. Por favor, ingrese un nombre diferente.");
            } else {
                validName = true;
            }
        }

        System.out.print("País: ");
        String country = scanner.nextLine();

        System.out.print("Ciudad: ");
        String city = scanner.nextLine();

        System.out.print("Dirección: ");
        String address = scanner.nextLine();

        System.out.print("Capacidad Máxima de Personas: ");
        int maxCapacity = Integer.parseInt(scanner.nextLine());

        LocalDate eventDate = null;
        boolean validDate = false;
        while (!validDate) {
            System.out.print("Fecha (formato yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                eventDate = LocalDate.parse(dateInput, dateFormatter);
                LocalDate currentDate = LocalDate.now();

                if (eventDate.isAfter(currentDate.plusDays(7))) {
                    validDate = true;
                } else {
                    System.out.println("La fecha debe ser al menos 7 días en el futuro. Intente nuevamente.");
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato de fecha inválido. Intente nuevamente.");
            }
        }

        LocalDateTime dateTime = null;
        boolean validTime = false;
        while (!validTime) {
            System.out.print("Hora (formato HH:mm): ");
            String timeInput = scanner.nextLine();
            try {
                // Verifica que la entrada tenga el formato correcto
                LocalDateTime tempDateTime = LocalDateTime.parse("2000-01-01T" + timeInput + ":00", DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
                dateTime = eventDate.atTime(tempDateTime.toLocalTime());
                validTime = true;
            } catch (DateTimeParseException e) {
                System.out.println("Formato de hora inválido. Intente nuevamente.");
            }
        }

        System.out.print("Organizador: ");
        String organizer = scanner.nextLine();

        System.out.print("Clasificación por Edad: ");
        String ageRating = scanner.nextLine();

        System.out.print("Estado (activo/finalizado/pendiente): ");
        String status = scanner.nextLine();

        System.out.print("Edad mínima con guardián: ");
        int minAgeWithGuardian = Integer.parseInt(scanner.nextLine());

        System.out.print("Edad mínima sin guardián: ");
        int minAgeWithoutGuardian = Integer.parseInt(scanner.nextLine());

        Event event = new Event(
                0, 
                name, 
                country, 
                city, 
                address, 
                maxCapacity, 
                java.sql.Timestamp.valueOf(dateTime), 
                organizer, 
                ageRating, 
                status, 
                minAgeWithGuardian, 
                minAgeWithoutGuardian
        );

        if (eventController.addEvent(event)) {
            System.out.println("Evento añadido exitosamente.");
        } else {
            System.out.println("No se pudo añadir el evento.");
        }

        System.out.println("Lista de todos los eventos:");
        eventController.getAllEvents().forEach(System.out::println);

        scanner.close();
    }
}
