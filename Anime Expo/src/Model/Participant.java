/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Juan Felipe Rubio
 */

public class Participant {
    private int participant_id;
    private String name;
    private int activity_id;
    
    public Participant(int participant_id, String name, int activity_id){
    this.participant_id = participant_id;
    this.name = name;
    this.activity_id = activity_id;
    }

    // Getter y Setter para participant_id
    public int getParticipant_id() {
        return participant_id;
    }

    public void setParticipant_id(int participant_id) {
        this.participant_id = participant_id;
    }

    // Getter y Setter para name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter y Setter para activity_id
    public int getActivity_id() {
        return activity_id;
    }

    public void setActivity_id(int activity_id) {
        this.activity_id = activity_id;
    }
}
