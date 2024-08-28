/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// folder import
import Model.Ticket;
import Dao.TicketDao;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class TicketController {
 private TicketDao ticketDao = new TicketDao();

    public boolean isEventNameExists(String name) {
        List<Ticket> eventstaffs = ticketDao.ViewTicket();
        for (Ticket eventstaff : eventstaffs) {
            if (eventstaff.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Ticket> getAllEventsStaff() {
        return ticketDao.ViewTicket();
    }
    public boolean AddEventStaff(Ticket ticket){
        return ticketDao.InsertTicket(ticket); 
    }
}