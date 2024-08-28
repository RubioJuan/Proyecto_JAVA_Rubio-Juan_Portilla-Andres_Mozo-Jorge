/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

// folder import
import Model.Visitor;
import Dao.VisitorDao;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class VisitorController {
    
    private VisitorDao visitorDao = new VisitorDao();

    public boolean isVisitorNameExists(String name){
        List<Visitor> visitors = visitorDao.viewVisitors(); 
        for(Visitor v : visitors){
            if (v.getName().equals(name)){
                return true;
            }
        }
        return false;
    }

    public List<Visitor> getAllVisitorss(){
        return visitorDao.viewVisitors();
    }
    
    public boolean addVisitor(Visitor visitor){
        return visitorDao.insertVisitor(visitor); // Corregido a insertVisitor
    }
}
