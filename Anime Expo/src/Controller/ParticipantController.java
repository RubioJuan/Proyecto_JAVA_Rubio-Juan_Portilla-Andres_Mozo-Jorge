package Controller;

import Model.Participant;
import Dao.ParticipantDao;
import View.ParticipantView;

import java.util.List;

public class ParticipantController {
    
    private ParticipantDao participantDao;
    private ParticipantView participantView;

    public ParticipantController(ParticipantDao participantDao, ParticipantView participantView) {
        this.participantDao = participantDao;
        this.participantView = participantView;
    }

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

    public boolean addEventStaff(Participant participant) {
        return participantDao.InsertParticipant(participant);
    }

    public void showParticipantList() {
        List<Participant> participants = getAllEventsStaff();
        participantView.displayParticipants(participants);
    }
}
