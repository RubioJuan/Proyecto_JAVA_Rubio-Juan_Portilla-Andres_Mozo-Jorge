/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Restaurant {
    private int restaurantId;
    private String name;
    private int managerId;

    public Restaurant() {
    }

    public Restaurant(int restaurantId, String name, int managerId) {
        this.restaurantId = restaurantId;
        this.name = name;
        this.managerId = managerId;
    }

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManagerId() {
        return managerId;
    }

    public void setManagerId(int managerId) {
        this.managerId = managerId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                 Restaurant Details                                   \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ Restaurant ID       : %-45d \n", restaurantId));
        sb.append(String.format("║ Name                : %-45s \n", name));
        sb.append(String.format("║ Manager ID          : %-45d \n", managerId));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
