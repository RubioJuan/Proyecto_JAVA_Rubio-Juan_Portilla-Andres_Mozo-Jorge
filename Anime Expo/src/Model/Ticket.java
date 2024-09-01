/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.math.BigDecimal;

/**
 *
 * @author Juan Felipe Rubio
 */

public class Ticket {
    private int ticket_type_id;
    private String name;
    private BigDecimal price;
    private String age_rating;
    private BigDecimal additional_costs;
    private String status;
    
    public Ticket(int ticket_type_id, String name, BigDecimal price, String age_rating, BigDecimal additional_costs, String status) {
    this.ticket_type_id = ticket_type_id;
    this.name = name;
    this.price = price;
    this.age_rating = age_rating;
    this.additional_costs = additional_costs;
    this.status = status;
    }
 
    // Getters
    public int getTicket_type_id() {
        return ticket_type_id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getAge_rating() {
        return age_rating;
    }

    public BigDecimal getAdditional_costs() {
        return additional_costs;
    }

    public String getStatus() {
        return status;
    }
    
    // Setters
    public void setTicket_type_id(int ticket_type_id) {
        this.ticket_type_id = ticket_type_id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setAge_rating(String age_rating) {
        this.age_rating = age_rating;
    }

    public void setAdditional_costs(BigDecimal additional_costs) {
        this.additional_costs = additional_costs;
    }

    public void setStatus(String status) {
        this.status = status;
    }

   @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Ticket Details                                      \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Ticket Type ID      : %-45d \n", ticket_type_id));
        sb.append(String.format("║ Name               : %-45s \n", name));
        sb.append(String.format("║ Price              : %-45.2f \n", price));
        sb.append(String.format("║ Age Rating         : %-45s \n", age_rating));
        sb.append(String.format("║ Additional Costs   : %-45.2f \n", additional_costs));
        sb.append(String.format("║ Status             : %-45s \n", status));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
