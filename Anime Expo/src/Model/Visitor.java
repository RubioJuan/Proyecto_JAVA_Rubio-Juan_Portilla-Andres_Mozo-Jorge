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

public class Visitor {
    private int visitor_id;
    private String name;
    private String id_number;
    private String gender;
    private Date birth_date;
    private String email;
    private String phone_number;
    private int ticket_type_id;
    
    public Visitor(int visitor_id, String name, String id_number,String gender,Date birth_date, String email, String phone_number, int ticket_type_id){
       this.visitor_id = visitor_id;
       this.name = name;
       this.id_number = id_number;
       this.gender = gender;
       this.birth_date = birth_date;
       this.email = email;
       this.phone_number = phone_number;
       this.ticket_type_id = ticket_type_id;
    }
    
      public int getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(int visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId_number() {
        return id_number;
    }

    public void setId_number(String id_number) {
        this.id_number = id_number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirth_date() {
        return birth_date;
    }

    public void setBirth_date(Date birth_date) {
        this.birth_date = birth_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public int getTicket_type_id() {
        return ticket_type_id;
    }

    public void setTicket_type_id(int ticket_type_id) {
        this.ticket_type_id = ticket_type_id;
    }

    @Override
    public String toString() {
        return "Visitor{" +
                "visitor_id=" + visitor_id +
                ", name='" + name + '\'' +
                ", id_number='" + id_number + '\'' +
                ", gender='" + gender + '\'' +
                ", birth_date=" + birth_date +
                ", email='" + email + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", ticket_type_id=" + ticket_type_id +
                '}';
    }
}