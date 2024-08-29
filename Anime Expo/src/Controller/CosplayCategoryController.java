/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.CosplayCategoryDao;
import Model.CosplayCategory;
import View.CosplayCategoryView;

import java.util.List;

public class CosplayCategoryController {
    private CosplayCategoryDao cosplayCategoryDao;
    private CosplayCategoryView cosplayCategoryView;

    public CosplayCategoryController(CosplayCategoryDao cosplayCategoryDao, CosplayCategoryView cosplayCategoryView) {
        this.cosplayCategoryDao = cosplayCategoryDao;
        this.cosplayCategoryView = cosplayCategoryView;
    }

    public void listAllCategories() {
        List<CosplayCategory> categories = cosplayCategoryDao.getAllCategories();
        cosplayCategoryView.displayCategoryList(categories);
    }

    public void createNewCategory() {
        CosplayCategory category = cosplayCategoryView.getNewCategoryDetails();
        cosplayCategoryDao.addCategory(category);
        System.out.println("Nueva categoría de cosplay añadida con éxito.");
    }
}
