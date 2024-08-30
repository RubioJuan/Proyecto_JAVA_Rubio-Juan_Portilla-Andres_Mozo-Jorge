/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jorge Luis Mozo
 */
public class Inventory {
    private int inventory_id;
    private String name;
    private int quantity;
    private String status;
    
    
    public Inventory (int inventory_id, String name, int quantity, String status) {
        this.inventory_id = inventory_id ;
        this.name = name ;
        this.quantity = quantity ;
        this.status = status;
    }
    public int getInventory_id (){
        return inventory_id;
    }
    public void SetInventory_id (int inventory_id){
        this.inventory_id = inventory_id;
    }
    public String getName (){
        return name;
    }
    public void SetName(String name){
        this.name = name;
    }
    public int getQuantity (){
        return quantity;
    }
    public void SetQuantity (int quantity){
        this.quantity = quantity;
    }
    public String getStatus (){
        return status;
    }
    public void SetStatus(String status){
        this.status = status;
    }
    
}
