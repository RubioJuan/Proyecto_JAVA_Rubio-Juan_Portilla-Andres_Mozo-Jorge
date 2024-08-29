/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.ReportDao;
import Model.Report;
import View.ReportView;

import java.util.List;

public class ReportController {
    private ReportDao reportDao;
    private ReportView reportView;

    public ReportController(ReportDao reportDao, ReportView reportView) {
        this.reportDao = reportDao;
        this.reportView = reportView;
    }

    public void listAllReports() {
        List<Report> reports = reportDao.getAllReports();
        reportView.displayReportList(reports);
    }

    public void createNewReport() {
        Report report = reportView.getNewReportDetails();
        reportDao.addReport(report);
        System.out.println("Nuevo reporte añadido con éxito.");
    }
}
