/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// folder import
import Model.Event;
import Dao.EventDao;
import View.EventView;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class EventController {
    
private EventDao eventDao;
    private EventView eventView;

    public EventController(EventDao eventDao, EventView eventView) {
        this.eventDao = eventDao;
        this.eventView = eventView;
    }
    
    public boolean addEvent(Event event) {
        if (isValidDate(LocalDateTime.ofInstant(event.getDate_time().toInstant(), ZoneId.systemDefault()))) {
            return eventDao.InsertEvent(event);
        } else {
            System.out.println("Error: Fecha inválida.");
            return false;
        }
    }

    private boolean isValidDate(LocalDateTime dateTime) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        return dateTime.isAfter(currentDateTime.plusDays(7));
    }

    public boolean isEventNameExists(String name) {
        List<Event> events = eventDao.ViewEvent();
        for (Event event : events) {
            if (event.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Event> getAllEvents() {
        return eventDao.ViewEvent();
    }
}