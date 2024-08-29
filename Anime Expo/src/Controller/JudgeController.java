/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.JudgeDao;
import Model.Judge;
import View.JudgeView;

import java.util.List;

public class JudgeController {
    private JudgeDao judgeDao;
    private JudgeView judgeView;

    public JudgeController(JudgeDao judgeDao, JudgeView judgeView) {
        this.judgeDao = judgeDao;
        this.judgeView = judgeView;
    }

    public void listAllJudges() {
        List<Judge> judges = judgeDao.getAllJudges();
        judgeView.displayJudgeList(judges);
    }

    public void createNewJudge() {
        Judge judge = judgeView.getNewJudgeDetails();
        judgeDao.addJudge(judge);
        System.out.println("Nuevo juez añadido con éxito.");
    }
}
