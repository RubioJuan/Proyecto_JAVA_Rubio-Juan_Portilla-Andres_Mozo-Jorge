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

    public Activity() {
    }

    public Activity(int activityId, String name, String type, String category, int participantCount, int eventId, String startTime) {
        this.activityId = activityId;
        this.name = name;
        this.type = type;
        this.category = category;
        this.participantCount = participantCount;
        this.eventId = eventId;
        this.startTime = startTime;
    }

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
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Activity Details                           \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Activity ID        : %-45d \n", activityId));
        sb.append(String.format("║ Name               : %-45s \n", name));
        sb.append(String.format("║ Type               : %-45s \n", type));
        sb.append(String.format("║ Category           : %-45s \n", category));
        sb.append(String.format("║ Participant Count  : %-45d \n", participantCount));
        sb.append(String.format("║ Event ID           : %-45d \n", eventId));
        sb.append(String.format("║ Start Time         : %-45s \n", startTime));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}