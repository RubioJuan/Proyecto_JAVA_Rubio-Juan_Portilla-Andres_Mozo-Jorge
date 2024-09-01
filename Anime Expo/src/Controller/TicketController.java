/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Controller;

import Model.Ticket;
import Dao.TicketDao;
import View.TicketView;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class TicketController {
    private TicketDao ticketDao;
    private TicketView ticketView;

    // Constructor que acepta el DAO y la Vista
    public TicketController(TicketDao ticketDao, TicketView ticketView) {
        this.ticketDao = ticketDao;
        this.ticketView = ticketView;
    }

    public boolean isEventNameExists(String name) {
        List<Ticket> tickets = ticketDao.ViewTicket();
        for (Ticket ticket : tickets) {
            if (ticket.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Ticket> getAllEventsStaff() {
        return ticketDao.ViewTicket();
    }

    public boolean AddEventStaff(Ticket ticket) {
        return ticketDao.InsertTicket(ticket);
    }
}