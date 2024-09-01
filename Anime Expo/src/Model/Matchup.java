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
    private Integer winnerId; 

    public Matchup(int matchupId, int roundId, int participant1Id, int participant2Id, Integer winnerId) {
        this.matchupId = matchupId;
        this.roundId = roundId;
        this.participant1Id = participant1Id;
        this.participant2Id = participant2Id;
        this.winnerId = winnerId;
    }

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
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Matchup Details                                    \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Matchup ID         : %-45d \n", matchupId));
        sb.append(String.format("║ Round ID           : %-45d \n", roundId));
        sb.append(String.format("║ Participant 1 ID   : %-45d \n", participant1Id));
        sb.append(String.format("║ Participant 2 ID   : %-45d \n", participant2Id));
        sb.append(String.format("║ Winner ID          : %-45d \n", winnerId));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
