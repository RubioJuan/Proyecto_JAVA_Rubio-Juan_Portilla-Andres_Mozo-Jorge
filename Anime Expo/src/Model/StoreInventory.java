package Model;

public class StoreInventory {
    private int inventory_id;
    private String product_name;
    private String description;
    private String manufacturer;
    private String type;
    private int quantity;
    private int price;

    public StoreInventory(int inventory_id, String product_name, String description, String manufacturer, String type, int quantity, int price) {
        this.inventory_id = inventory_id;
        this.product_name = product_name;
        this.description = description;
        this.manufacturer = manufacturer;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters and Setters
    public int getInventory_id() {
        return inventory_id;
    }

    public void setInventory_id(int inventory_id) {
        this.inventory_id = inventory_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ID: " + inventory_id + ", Product: " + product_name + ", Description: " + description + 
               ", Manufacturer: " + manufacturer + ", Type: " + type + ", Quantity: " + quantity + 
               ", Price: " + price;
    }
}
