/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Matchup {
    private int matchupId;
    private int roundId;
    private int participant1Id;
    private int participant2Id;
    private Integer winnerId; // Puede ser null si no hay un ganador aún

    public Matchup(int matchupId, int roundId, int participant1Id, int participant2Id, Integer winnerId) {
        this.matchupId = matchupId;
        this.roundId = roundId;
        this.participant1Id = participant1Id;
        this.participant2Id = participant2Id;
        this.winnerId = winnerId;
    }

    // Getters y setters
    public int getMatchupId() { return matchupId; }
    public void setMatchupId(int matchupId) { this.matchupId = matchupId; }
    public int getRoundId() { return roundId; }
    public void setRoundId(int roundId) { this.roundId = roundId; }
    public int getParticipant1Id() { return participant1Id; }
    public void setParticipant1Id(int participant1Id) { this.participant1Id = participant1Id; }
    public int getParticipant2Id() { return participant2Id; }
    public void setParticipant2Id(int participant2Id) { this.participant2Id = participant2Id; }
    public Integer getWinnerId() { return winnerId; }
    public void setWinnerId(Integer winnerId) { this.winnerId = winnerId; }

    @Override
    public String toString() {
        return "Matchup{" +
                "matchupId=" + matchupId +
                ", roundId=" + roundId +
                ", participant1Id=" + participant1Id +
                ", participant2Id=" + participant2Id +
                ", winnerId=" + winnerId +
                '}';
    }
}
