package Model;

public class ActivityPrize {
    private int prizeId;
    private String type;
    private String description;
    private double value;
    private String status;
    private int activityId;
    private int participantId;

    public ActivityPrize(int prizeId, String type, String description, double value, String status, int activityId, int participantId) {
        this.prizeId = prizeId;
        this.type = type;
        this.description = description;
        this.value = value;
        this.status = status;
        this.activityId = activityId;
        this.participantId = participantId;
    }

    public int getPrizeId() { return prizeId; }
    public void setPrizeId(int prizeId) { this.prizeId = prizeId; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public int getActivityId() { return activityId; }
    public void setActivityId(int activityId) { this.activityId = activityId; }
    public int getParticipantId() { return participantId; }
    public void setParticipantId(int participantId) { this.participantId = participantId; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                               Activity Prize Details                              \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Prize ID           : %-45d \n", prizeId));
        sb.append(String.format("║ Type               : %-45s \n", type));
        sb.append(String.format("║ Description        : %-45s \n", description));
        sb.append(String.format("║ Value              : %-45d \n", value));
        sb.append(String.format("║ Status             : %-45s \n", status));
        sb.append(String.format("║ Activity ID        : %-45d \n", activityId));
        sb.append(String.format("║ Participant ID     : %-45d \n", participantId));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
