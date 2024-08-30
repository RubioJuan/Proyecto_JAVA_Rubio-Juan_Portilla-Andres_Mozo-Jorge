/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.RestaurantDao;
import Model.Restaurant;

import java.util.List;

public class RestaurantController {
    private RestaurantDao restaurantDao;

    public RestaurantController() {
        restaurantDao = new RestaurantDao();
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
