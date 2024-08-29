/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Round {
    private int roundId;
    private int eventId;
    private int roundNumber;
    private String description;

    public Round(int roundId, int eventId, int roundNumber, String description) {
        this.roundId = roundId;
        this.eventId = eventId;
        this.roundNumber = roundNumber;
        this.description = description;
    }

    public int getRoundId() {
        return roundId;
    }

    public void setRoundId(int roundId) {
        this.roundId = roundId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Round{" +
                "roundId=" + roundId +
                ", eventId=" + eventId +
                ", roundNumber=" + roundNumber +
                ", description='" + description + '\'' +
                '}';
    }
}
