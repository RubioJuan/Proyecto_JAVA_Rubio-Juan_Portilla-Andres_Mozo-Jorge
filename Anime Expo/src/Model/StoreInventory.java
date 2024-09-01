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
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                Inventory Details                                    \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ ID                  : %-45d \n", inventory_id));
        sb.append(String.format("║ Product             : %-45s \n", product_name));
        sb.append(String.format("║ Description         : %-45s \n", description));
        sb.append(String.format("║ Manufacturer        : %-45s \n", manufacturer));
        sb.append(String.format("║ Type                : %-45s \n", type));
        sb.append(String.format("║ Quantity            : %-45d \n", quantity));
        sb.append(String.format("║ Price               : %-45.2f \n", price));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
