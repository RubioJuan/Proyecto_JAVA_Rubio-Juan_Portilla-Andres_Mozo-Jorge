/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.ActivityPrizeDao;
import Model.ActivityPrize;
import View.ActivityPrizeView;

import java.util.List;

public class ActivityPrizeController {
    private ActivityPrizeDao activityPrizeDao;
    private ActivityPrizeView activityPrizeView;

    public ActivityPrizeController(ActivityPrizeDao activityPrizeDao, ActivityPrizeView activityPrizeView) {
        this.activityPrizeDao = activityPrizeDao;
        this.activityPrizeView = activityPrizeView;
    }

    public void listAllPrizes() {
        List<ActivityPrize> prizes = activityPrizeDao.getAllPrizes();
        activityPrizeView.displayPrizeList(prizes);
    }

    public void createNewPrize() {
        ActivityPrize prize = activityPrizeView.getNewPrizeDetails();
        activityPrizeDao.addPrize(prize);
        System.out.println("Nuevo premio añadido con éxito.");
    }
}
