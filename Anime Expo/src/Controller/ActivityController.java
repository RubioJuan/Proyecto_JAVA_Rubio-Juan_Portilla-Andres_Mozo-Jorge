/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

 package controller;

 import model.Activity;
 import dao.ActivityDao;
 import java.util.List;
 
 public class ActivityController {
 
     private ActivityDao activityDao;
 
     public ActivityController() {
         this.activityDao = new ActivityDao();
     }
 
     public void createActivity(Activity activity) {
         try {
             activityDao.createActivity(activity);
         } catch (Exception e) {
             System.err.println("Error al crear la actividad: " + e.getMessage());
         }
     }
 
     public List<Activity> getAllActivities() {
         try {
             return activityDao.getAllActivities();
         } catch (Exception e) {
             System.err.println("Error al obtener las actividades: " + e.getMessage());
             return null;
         }
     }
 
     public void updateActivity(Activity activity) {
         try {
             activityDao.updateActivity(activity);
         } catch (Exception e) {
             System.err.println("Error al actualizar la actividad: " + e.getMessage());
         }
     }
 
     public void deleteActivity(int activityId) {
         try {
             activityDao.deleteActivity(activityId);
         } catch (Exception e) {
             System.err.println("Error al eliminar la actividad: " + e.getMessage());
         }
     }
 }
 