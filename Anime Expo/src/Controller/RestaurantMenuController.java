package Controller;

import Dao.RestaurantMenuDao;
import Model.RestaurantMenu;

import java.util.List;

public class RestaurantMenuController {
    private final RestaurantMenuDao menuDao;

    // Modificado para aceptar un RestaurantMenuDao
    public RestaurantMenuController(RestaurantMenuDao menuDao) {
        this.menuDao = menuDao;
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
