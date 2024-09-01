/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class IngredientInventory {
    private int ingredientId;
    private int restaurantId;
    private String ingredientName;
    private int quantity;

    public IngredientInventory() {
    }

    public IngredientInventory(int ingredientId, int restaurantId, String ingredientName, int quantity) {
        this.ingredientId = ingredientId;
        this.restaurantId = restaurantId;
        this.ingredientName = ingredientName;
        this.quantity = quantity;
    }

    public int getIngredientId() {
        return ingredientId;
    }

    public void setIngredientId(int ingredientId) {
        this.ingredientId = ingredientId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                            Ingredient Inventory Details                             \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Ingredient ID      : %-45d \n", ingredientId));
        sb.append(String.format("║ Restaurant ID      : %-45d \n", restaurantId));
        sb.append(String.format("║ Ingredient Name    : %-45s \n", ingredientName));
        sb.append(String.format("║ Quantity           : %-45d \n", quantity));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
