/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// folder import
import Model.EventStaff;
import Dao.EventStaffDao;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class EventStaffController {
        
 private EventStaffDao eventStaffDao = new EventStaffDao();

    public boolean isEventNameExists(String name) {
        List<EventStaff> eventstaffs = eventStaffDao.ViewEvent();
        for (EventStaff eventstaff : eventstaffs) {
            if (eventstaff.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<EventStaff> getAllEventsStaff() {
        return eventStaffDao.ViewEvent();
    }
    public boolean AddEventStaff(EventStaff eventstaff){
        return eventStaffDao.InsertEventSatff(eventstaff); 
    }
}