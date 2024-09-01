package Controller;

import Dao.RestaurantDao;
import Model.Restaurant;

import java.util.List;

public class RestaurantController {
    private final RestaurantDao restaurantDao;

    public RestaurantController(RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }

    public boolean addRestaurant(String name, int managerId) {
        Restaurant restaurant = new Restaurant(0, name, managerId);
        return restaurantDao.addRestaurant(restaurant);
    }

    public List<Restaurant> getAllRestaurants() {
        return restaurantDao.getAllRestaurants();
    }

    public boolean updateRestaurant(int restaurantId, String name, int managerId) {
        Restaurant restaurant = new Restaurant(restaurantId, name, managerId);
        return restaurantDao.updateRestaurant(restaurant);
    }

    public boolean deleteRestaurant(int restaurantId) {
        return restaurantDao.deleteRestaurant(restaurantId);
    }
}
