/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.ScoreDao;
import Model.Score;
import View.ScoreView;

import java.util.List;

public class ScoreController {
    private ScoreDao scoreDao;
    private ScoreView scoreView;

    public ScoreController(ScoreDao scoreDao, ScoreView scoreView) {
        this.scoreDao = scoreDao;
        this.scoreView = scoreView;
    }

    public void listAllScores() {
        List<Score> scores = scoreDao.getAllScores();
        scoreView.displayScoreList(scores);
    }

    public void createNewScore() {
        Score score = scoreView.getNewScoreDetails();
        scoreDao.addScore(score);
        System.out.println("Nueva puntuación añadida con éxito.");
    }
}
