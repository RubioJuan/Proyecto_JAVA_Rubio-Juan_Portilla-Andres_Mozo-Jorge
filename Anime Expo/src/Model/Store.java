/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Jorge Luis Mozo
 */
public class Store {
    private int store_id;
    private String name;
    private String description;
    private int manager;
    
    public Store (int store_id, String name, String description, int manager) {
        this.store_id = store_id;
        this.name = name;
        this.description = description;
        this.manager = manager;
    }
    
    public int getStore_id() {
        return store_id;
    }
    public void setStore_id (int store_id){
        this.store_id = store_id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription (String description){
        this.description = description;
    }
    public int getManager() {
        return manager;
    }
    public void setManager (int manager){
        this.manager = manager;
    }
}
