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

public class Event {
    private int event_id;
    private String name;
    private String country;
    private String city;
    private String address;
    private int max_capacity;
    private Date date_time;
    private String organizer;
    private String age_rating;
    private String status;
    private  int min_age_with_guardian;
    private int min_age_without_guardian;

   public Event(int event_id, String name, String country, String city, String address, int max_capacity, Date date_time, String organizer, String age_rating, String status, int min_age_with_guardian, int min_age_without_guardian) {
    this.event_id = event_id;
    this.name = name;
    this.country = country;
    this.city = city;
    this.address = address;
    this.max_capacity = max_capacity;
    this.date_time = date_time;
    this.organizer = organizer;
    this.age_rating = age_rating;
    this.status = status;
    this.min_age_with_guardian = min_age_with_guardian;
    this.min_age_without_guardian = min_age_without_guardian;
    }

    public Event(int aInt, String string, String string0, String string1, String string2, int aInt0, java.sql.Date date, String string3, String string4, String string5, int aInt1, int aInt2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String Address) {
        this.address = address;
    }

    public int getMax_capacity() {
        return max_capacity;
    }

    public void setMax_capacity(int max_capacity) {
        this.max_capacity = max_capacity;
    }

    public Date getDate_time() {
        return date_time;
    }

    public void setDate_time(Date date_time) {
        this.date_time = date_time;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer;
    }

    public String getAge_rating() {
        return age_rating;
    }

    public void setAge_rating(String age_rating) {
        this.age_rating = age_rating;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getMin_age_with_guardian() {
        return min_age_with_guardian;
    }

    public void setMin_age_with_guardian(int min_age_with_guardian) {
        this.min_age_with_guardian = min_age_with_guardian;
    }

    public int getMin_age_without_guardian() {
        return min_age_without_guardian;
    }

    public void setMin_age_without_guardian(int min_age_without_guardian) {
        this.min_age_without_guardian = min_age_without_guardian;
    }

    @Override
    public String toString() {
        return "EventModel{" + "EventID= " + event_id + ", Name= " + name + ", Country= " + country + ", City= " + city + ", Address= " + address + ", max_capacity= " + max_capacity + ", date_time= " + date_time + ", organizer= " + organizer + ", age_rating= " + age_rating + ", status= " + status + ", min_age_with_guardian= " + min_age_with_guardian + ", min_age_without_guardian= " + min_age_without_guardian +'}';
    }  
}
