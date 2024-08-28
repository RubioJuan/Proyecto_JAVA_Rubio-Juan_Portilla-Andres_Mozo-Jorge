/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// folder import
import Model.Participant;
import Dao.ParticipantDao;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class ParticipantController {
    
     private ParticipantDao participantDao = new ParticipantDao();

      public boolean isEventNameExists(String name) {
        List<Participant> participants = participantDao.ViewParticipant();
        for (Participant eventstaff : participants) {
            if (eventstaff.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Participant> getAllEventsStaff() {
        return participantDao.ViewParticipant();
    }
    public boolean AddEventStaff(Participant participant){
        return participantDao.InsertParticipant(participant); 
    }
}
