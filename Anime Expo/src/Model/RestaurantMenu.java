/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class RestaurantMenu {
    private int menuId;
    private int restaurantId;
    private String dishName;
    private String description;
    private String type;
    private int prepTime;

    public RestaurantMenu() {
    }

    public RestaurantMenu(int menuId, int restaurantId, String dishName, String description, String type, int prepTime) {
        this.menuId = menuId;
        this.restaurantId = restaurantId;
        this.dishName = dishName;
        this.description = description;
        this.type = type;
        this.prepTime = prepTime;
    }

    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrepTime() {
        return prepTime;
    }

    public void setPrepTime(int prepTime) {
        this.prepTime = prepTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                               Restaurant Menu Details                                 \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Menu ID             : %-45d \n", menuId));
        sb.append(String.format("║ Restaurant ID       : %-45d \n", restaurantId));
        sb.append(String.format("║ Dish Name           : %-45s \n", dishName));
        sb.append(String.format("║ Description         : %-45s \n", description));
        sb.append(String.format("║ Type                : %-45s \n", type));
        sb.append(String.format("║ Preparation Time    : %-45d \n", prepTime));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
