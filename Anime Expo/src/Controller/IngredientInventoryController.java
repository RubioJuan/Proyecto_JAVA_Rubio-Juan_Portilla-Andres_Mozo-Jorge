package Controller;

import Dao.IngredientInventoryDao;
import Model.IngredientInventory;

import java.util.List;

public class IngredientInventoryController {
    private final IngredientInventoryDao ingredientDao;

    public IngredientInventoryController(IngredientInventoryDao ingredientDao) {
        this.ingredientDao = ingredientDao;
    }

    public boolean addIngredient(int restaurantId, String ingredientName, int quantity) {
        IngredientInventory ingredient = new IngredientInventory(0, restaurantId, ingredientName, quantity);
        return ingredientDao.addIngredient(ingredient);
    }

    public List<IngredientInventory> getAllIngredients(int restaurantId) {
        return ingredientDao.getAllIngredients(restaurantId);
    }

    public boolean updateIngredient(int ingredientId, String ingredientName, int quantity) {
        IngredientInventory ingredient = new IngredientInventory(ingredientId, 0, ingredientName, quantity);
        return ingredientDao.updateIngredient(ingredient);
    }

    public boolean deleteIngredient(int ingredientId) {
        return ingredientDao.deleteIngredient(ingredientId);
    }
}
