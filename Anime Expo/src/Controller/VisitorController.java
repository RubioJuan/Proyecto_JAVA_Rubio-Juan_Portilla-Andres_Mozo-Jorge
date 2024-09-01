/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */package Controller;

import Model.Visitor;
import Dao.VisitorDao;
import View.VisitorView;

import java.util.List;

/**
 *
 * @author Juan Felipe Rubio
 */

public class VisitorController {
    private VisitorDao visitorDao;
    private VisitorView visitorView;

    // Constructor que acepta el DAO y la Vista
    public VisitorController(VisitorDao visitorDao, VisitorView visitorView) {
        this.visitorDao = visitorDao;
        this.visitorView = visitorView;
    }

    public boolean isVisitorNameExists(String name) {
        List<Visitor> visitors = visitorDao.viewVisitors();
        for (Visitor visitor : visitors) {
            if (visitor.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Visitor> getAllVisitorss() {
        return visitorDao.viewVisitors();
    }

    public boolean addVisitor(Visitor visitor) {
        return visitorDao.insertVisitor(visitor);
    }
}
