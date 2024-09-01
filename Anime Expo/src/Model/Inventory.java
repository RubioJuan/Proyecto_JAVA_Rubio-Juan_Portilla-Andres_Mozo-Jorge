/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Inventory {
    private int inventory_id;
    private String name;
    private int quantity;
    private String status;
    private int eventId; // Nuevo campo para relacionar con eventos

    public Inventory(int inventory_id, String name, int quantity, String status, int eventId) {
        this.inventory_id = inventory_id;
        this.name = name;
        this.quantity = quantity;
        this.status = status;
        this.eventId = eventId;
    }

    // Getters y Setters
    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }
}
