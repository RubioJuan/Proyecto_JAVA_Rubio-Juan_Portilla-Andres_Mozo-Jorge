/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


/**
 *
 * @author Jorge Luis Mozo
 */
<<<<<<< HEAD
<<<<<<< HEAD
public class StoreInventory {
=======
public class StoreInventory  {
>>>>>>> f33fb4c29a60f70914f15876f2d8495cebc85389
=======
public class StoreInventory  {

>>>>>>> 1bbd38aea08e1efc59a050bd2d740574eeff4391
    private int inventory_id;
    private String product_name;
    private String description;
    private String manufacter;
    private String type;
    private int quantity;
    private int price;
    
    public StoreInventory (int inventory_id,  String product_name,String description, String manufacter, String type, int quantity, int price){
        this.inventory_id = inventory_id;
        this.product_name = product_name;
        this.description = description;
        this.manufacter = manufacter;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getInventory_id (){
        return inventory_id;
    }
    public void setInventory_id (int inventory_id){
        this.inventory_id = inventory_id;
    }
    public String getProduct_name (){
        return product_name;
    }
    public void setProduct_name (String product_name){
        this.product_name = product_name;
    }
    public String getDescription (){
        return description;
    }
    public void setDescription (String description){
        this.description = description;
    }
    public String getManufacter (){
        return manufacter;
    }
    public void setManufacter (String manufacter){
        this.manufacter = manufacter;
    }
    public String getType (){
        return type;
    }
    public void setType (String type){
        this.type = type;
    }
    public int getQuantity (){
        return quantity;
    }
    public void setquantity (int quantity){
        this.quantity = quantity;
    }
    public int getPrice (){
        return price;
    }
    public void setPrice(int price){
        this.price = price;
    }
    
    
    
}
