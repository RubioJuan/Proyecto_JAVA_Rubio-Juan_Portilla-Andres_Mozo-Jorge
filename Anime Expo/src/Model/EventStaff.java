/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.Date;

/**
 *
 * @author Juan Felipe Rubio
 */

public class EventStaff {
    private int staff_id;
    private String name;
    private String id_number;
    private Date birth_date;
    private String role;
    private String status;
    private int event_id;
    
    public EventStaff(int staff_id,String name, String id_number,Date birth_date,String role,String status, int event_id){
    this.staff_id =staff_id;
    this.name = name;
    this.id_number = id_number;
    this.birth_date = birth_date;
    this.role = role;
    this.status = status;
    this.event_id = event_id;
    }
    
    // Getters
    public int getStaff_id() {
        return staff_id;
    }

    public String getName() {
        return name;
    }

    public String getId_number() {
        return id_number;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    public int getEvent_id() {
        return event_id;
    }

    // Setters
    public void setStaff_id(int staff_id) {
        this.staff_id = staff_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }
    // Override toString method
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Event Staff Details                                \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Staff ID           : %-45d \n", staff_id));
        sb.append(String.format("║ Name               : %-45s \n", name));
        sb.append(String.format("║ ID Number          : %-45s \n", id_number));
        sb.append(String.format("║ Birth Date         : %-45s \n", birth_date));
        sb.append(String.format("║ Role               : %-45s \n", role));
        sb.append(String.format("║ Status             : %-45s \n", status));
        sb.append(String.format("║ Event ID           : %-45d \n", event_id));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}