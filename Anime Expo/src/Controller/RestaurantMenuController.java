/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.RestaurantMenuDao;
import Model.RestaurantMenu;

import java.util.List;

public class RestaurantMenuController {
    private RestaurantMenuDao menuDao;

    public RestaurantMenuController() {
        menuDao = new RestaurantMenuDao();
    }

    public boolean addDish(int restaurantId, String dishName, String description, String type, int prepTime) {
        RestaurantMenu menu = new RestaurantMenu(0, restaurantId, dishName, description, type, prepTime);
        return menuDao.addDish(menu);
    }

    public List<RestaurantMenu> getAllDishes(int restaurantId) {
        return menuDao.getAllDishes(restaurantId);
    }

    public boolean updateDish(int menuId, String dishName, String description, String type, int prepTime) {
        RestaurantMenu menu = new RestaurantMenu(menuId, 0, dishName, description, type, prepTime);
        return menuDao.updateDish(menu);
    }

    public boolean deleteDish(int menuId) {
        return menuDao.deleteDish(menuId);
    }
}
