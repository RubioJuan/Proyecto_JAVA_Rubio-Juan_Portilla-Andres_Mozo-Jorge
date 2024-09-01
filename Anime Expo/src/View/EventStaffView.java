/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package View;

import Controller.EventStaffController;
import Model.EventStaff;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */
public class EventStaffView {

    private EventStaffController eventStaffController;

    // Constructor vacío
    public EventStaffView() {
    }

    // Método para asignar el controlador
    public void setEventStaffController(EventStaffController eventStaffController) {
        this.eventStaffController = eventStaffController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        System.out.println("Ingrese los datos del personal de evento:");

        boolean validName = false;
        while (!validName) {
            System.out.println("Nombre del personal: ");
            name = scanner.nextLine();

            if (eventStaffController.isEventNameExists(name)) {
                System.out.println("Lastimosamente ya existe un personal con este nombre, por favor ingrese un nombre diferente.");
            } else {
                validName = true;
            }
        }

        System.out.println("Numero de telefono: ");
        String id_number = scanner.nextLine();

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

        System.out.println("Ingrese el rol: ");
        String role = scanner.nextLine();

        System.out.println("Ingrese el estado (assigned, no task, dismissed, incapacitated) ");
        String status = scanner.nextLine();

        System.out.println("Ingrese el id del evento: ");
        int event_id = Integer.parseInt(scanner.nextLine());

        EventStaff eventstaff = new EventStaff(
                0, name, id_number, birth_date, role, status, event_id
        );

        if (eventStaffController.AddEventStaff(eventstaff)) {
            System.out.println("Personal añadido exitosamente.");
        } else {
            System.out.println("No se pudo añadir el personal.");
        }

        System.out.println("Lista de todos los empleados de personal:");
        eventStaffController.getAllEventsStaff().forEach(System.out::println);

        scanner.close();
    }
}