/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Controller.ParticipantController;
import Model.Participant;

import java.util.Scanner;

/**
 *
 * @author Juan Felipe Rubio
 */

public class ParticipantView {
   public static void main(String[] args) {
        ParticipantController controller = new ParticipantController();
        Scanner scanner = new Scanner(System.in); String name = "";
        
                System.out.println("Ingrese los datos del participante:");
                
        boolean validName = false;
        while(!validName){
            System.out.println("Nombre del participante: ");
            name = scanner.nextLine();
            
            if(controller.isEventNameExists(name)){
                System.out.println("Lastimosamente ya existe un participante con este nombre, por favor ingrese un nombre diferente.");
            } else{
                validName = true;
            }
        }
        
        System.out.println("Ingrese el id de la actividad que va a participar: ");
        int activity_id = Integer.parseInt(scanner.nextLine());
        
        Participant participant = new Participant(
            0, name, activity_id
        );
        
        if(controller.AddEventStaff(participant)){
            System.out.println("Participante añadido exitosamente.");
        } else {
            System.out.println("No se pudo añadir el participante.");
        }
        
        System.out.println("Lista de todos los participantes:");
        controller.getAllEventsStaff().forEach(System.out::println);
        
        scanner.close();
    }
}
