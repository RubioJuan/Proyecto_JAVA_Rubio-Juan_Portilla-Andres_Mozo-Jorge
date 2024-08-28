/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Juan Felipe Rubio
 */

public class VisitorFeedback {
    private int feedback_id;
    private int event_id;
    private int visitor_id;
    private String comment;
    private int rating;
    
    public VisitorFeedback(int feedback_id,int event_id,int visitor_id, String comment, int rating){
        this.feedback_id = feedback_id;
        this.event_id = event_id;
        this.visitor_id = visitor_id;
        this.comment = comment;
        this.rating = rating;
    }
    
    public int getFeedback_id() {
        return feedback_id;
    }

    public void setFeedback_id(int feedback_id) {
        this.feedback_id = feedback_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int event_id) {
        this.event_id = event_id;
    }

    public int getVisitor_id() {
        return visitor_id;
    }

    public void setVisitor_id(int visitor_id) {
        this.visitor_id = visitor_id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
