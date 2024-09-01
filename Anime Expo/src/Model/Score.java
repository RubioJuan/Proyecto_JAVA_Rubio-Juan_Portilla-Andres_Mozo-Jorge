/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Score {
    private int scoreId;
    private int participantId;
    private int activityId;
    private double score;

    public Score(int scoreId, int participantId, int activityId, double score) {
        this.scoreId = scoreId;
        this.participantId = participantId;
        this.activityId = activityId;
        this.score = score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
    }

    public int getParticipantId() {
        return participantId;
    }

    public void setParticipantId(int participantId) {
        this.participantId = participantId;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Score Details                                       \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Score ID            : %-45d \n", scoreId));
        sb.append(String.format("║ Participant ID      : %-45d \n", participantId));
        sb.append(String.format("║ Activity ID         : %-45d \n", activityId));
        sb.append(String.format("║ Score               : %-45d \n", score));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
