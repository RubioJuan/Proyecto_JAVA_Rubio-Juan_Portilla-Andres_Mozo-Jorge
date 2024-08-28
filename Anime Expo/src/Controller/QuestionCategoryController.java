/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.QuestionCategoryDao;
import Model.QuestionCategory;
import View.QuestionCategoryView;

import java.util.List;

public class QuestionCategoryController {
    private QuestionCategoryDao categoryDao;
    private QuestionCategoryView categoryView;

    public QuestionCategoryController(QuestionCategoryDao categoryDao, QuestionCategoryView categoryView) {
        this.categoryDao = categoryDao;
        this.categoryView = categoryView;
    }

    public void listAllCategories() {
        List<QuestionCategory> categories = categoryDao.getAllCategories();
        categoryView.displayCategoryList(categories);
    }

    public void createNewCategory() {
        QuestionCategory category = categoryView.getNewCategoryDetails();
        categoryDao.addCategory(category);
        System.out.println("Nueva categoría añadida con éxito.");
    }
}
