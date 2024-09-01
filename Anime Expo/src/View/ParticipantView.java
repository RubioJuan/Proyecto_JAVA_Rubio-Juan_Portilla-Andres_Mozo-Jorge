package View;

import Controller.ParticipantController;
import Model.Participant;

import java.util.List;
import java.util.Scanner;

public class ParticipantView {

    public ParticipantController participantController;

    public ParticipantView(ParticipantController participantController) {
        this.participantController = participantController;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String name = "";

        System.out.println("Ingrese los datos del participante:");

        boolean validName = false;
        while (!validName) {
            System.out.println("Nombre del participante: ");
            name = scanner.nextLine();

            if (participantController.isEventNameExists(name)) {
                System.out.println("Lamentablemente ya existe un participante con este nombre, por favor ingrese un nombre diferente.");
            } else {
                validName = true;
            }
        }

        System.out.println("Ingrese el id de la actividad en la que va a participar: ");
        int activityId = Integer.parseInt(scanner.nextLine());

        Participant participant = new Participant(0, name, activityId);

        if (participantController.addEventStaff(participant)) {
            System.out.println("Participante añadido exitosamente.");
        } else {
            System.out.println("No se pudo añadir el participante.");
        }

        showParticipantList();
        scanner.close();
    }

    public void showParticipantList() {
        List<Participant> participants = participantController.getAllEventsStaff();
        displayParticipants(participants);
    }

    public void displayParticipants(List<Participant> participants) {
        System.out.println("Lista de todos los participantes:");
        participants.forEach(System.out::println);
    }
}
