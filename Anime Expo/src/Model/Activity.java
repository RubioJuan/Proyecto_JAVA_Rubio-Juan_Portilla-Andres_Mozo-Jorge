/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author Andres Felipe Portilla Amorocho 
 */
public class Activity {
    private int activityId;
    private String name;
    private String type;
    private String category;
    private int participantCount;
    private int eventId;
    private String startTime;

    // Constructor vacío
    public Activity() {
    }

    // Constructor con parámetros
    public Activity(int activityId, String name, String type, String category, int participantCount, int eventId, String startTime) {
        this.activityId = activityId;
        this.name = name;
        this.type = type;
        this.category = category;
        this.participantCount = participantCount;
        this.eventId = eventId;
        this.startTime = startTime;
    }

    // Getters y Setters
    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getParticipantCount() {
        return participantCount;
    }

    public void setParticipantCount(int participantCount) {
        this.participantCount = participantCount;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId=" + activityId +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", category='" + category + '\'' +
                ", participantCount=" + participantCount +
                ", eventId=" + eventId +
                ", startTime='" + startTime + '\'' +
                '}';
    }
}
