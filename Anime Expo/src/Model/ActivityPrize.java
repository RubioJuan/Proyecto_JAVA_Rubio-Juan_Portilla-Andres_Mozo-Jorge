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
        return "ActivityPrize{" +
                "prizeId=" + prizeId +
                ", type='" + type + '\'' +
                ", description='" + description + '\'' +
                ", value=" + value +
                ", status='" + status + '\'' +
                ", activityId=" + activityId +
                ", participantId=" + participantId +
                '}';
    }
}
