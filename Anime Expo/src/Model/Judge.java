/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


import java.util.Date;

public class Judge {
    private int judgeId;
    private String name;
    private String idNumber;
    private Date birthDate;
    private String email;
    private String phoneNumber;
    private String specialty;
    private int eventId;

    public Judge(int judgeId, String name, String idNumber, Date birthDate, String email, String phoneNumber, String specialty, int eventId) {
        this.judgeId = judgeId;
        this.name = name;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.specialty = specialty;
        this.eventId = eventId;
    }

    // Getters y setters
    public int getJudgeId() { return judgeId; }
    public void setJudgeId(int judgeId) { this.judgeId = judgeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getIdNumber() { return idNumber; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPhoneNumber() { return phoneNumber; }
    public void setPhoneNumber(String phoneNumber) { this.phoneNumber = phoneNumber; }
    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
    public int getEventId() { return eventId; }
    public void setEventId(int eventId) { this.eventId = eventId; }

    @Override
    public String toString() {
        return "Judge{" +
                "judgeId=" + judgeId +
                ", name='" + name + '\'' +
                ", idNumber='" + idNumber + '\'' +
                ", birthDate=" + birthDate +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", specialty='" + specialty + '\'' +
                ", eventId=" + eventId +
                '}';
    }
}
