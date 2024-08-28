/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package Controller;

import Dao.ActivityDao;
import Model.Activity;
import View.ActivityView;

import java.util.List;

public class ActivityController {

    private final ActivityDao activityDao;
    private final ActivityView activityView;

    public ActivityController(ActivityDao activityDao, ActivityView activityView) {
        this.activityDao = activityDao;
        this.activityView = activityView;
    }

    public void listAllActivities() {
        List<Activity> activities = activityDao.getAllActivities();
        activityView.displayActivityList(activities);
    }

    public void createNewActivity() {
        Activity newActivity = activityView.getNewActivityDetails();
        boolean success = activityDao.addActivity(newActivity);
        if (success) {
            System.out.println("Actividad agregada exitosamente.");
        } else {
            System.out.println("Error al agregar la actividad.");
        }
    }
}
