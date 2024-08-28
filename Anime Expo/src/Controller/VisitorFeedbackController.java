/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// folder import
import Model.VisitorFeedback;
import Dao.VisitorFeedbackDao;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class VisitorFeedbackController {
    
    private VisitorFeedbackDao visitorfeedbackDao = new VisitorFeedbackDao();

     
    public boolean isVisitorFeedbackExists(int event_id) {
    List<VisitorFeedback> visitorfeedbacks = visitorfeedbackDao.ViewVisitorFeedback();
    for (VisitorFeedback visitorfeedback : visitorfeedbacks) {
        if (visitorfeedback.getEvent_id() == event_id) {
            return true;
        }
    }
    return false;
}


    public List<VisitorFeedback> getAllVisitorFeedback() {
        return visitorfeedbackDao.ViewVisitorFeedback();
    }
    
    public boolean AddVisitorFeedback(VisitorFeedback visitorfeedback){
        return visitorfeedbackDao.InsertVisitorFeedback(visitorfeedback); 
    }
}