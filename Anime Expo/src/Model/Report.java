/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Report {
    private int reportId;
    private int eventId;
    private String reportType;
    private String content;

    public Report(int reportId, int eventId, String reportType, String content) {
        this.reportId = reportId;
        this.eventId = eventId;
        this.reportType = reportType;
        this.content = content;
    }

    public int getReportId() {
        return reportId;
    }

    public void setReportId(int reportId) {
        this.reportId = reportId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getReportType() {
        return reportType;
    }

    public void setReportType(String reportType) {
        this.reportType = reportType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Report Details                                        \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Report ID           : %-45d \n", reportId));
        sb.append(String.format("║ Event ID            : %-45d \n", eventId));
        sb.append(String.format("║ Report Type         : %-45s \n", reportType));
        sb.append(String.format("║ Content             : %-45s \n", content));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
