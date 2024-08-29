/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.MatchupDao;
import Model.Matchup;
import View.MatchupView;

import java.util.List;

public class MatchupController {
    private MatchupDao matchupDao;
    private MatchupView matchupView;

    public MatchupController(MatchupDao matchupDao, MatchupView matchupView) {
        this.matchupDao = matchupDao;
        this.matchupView = matchupView;
    }

    public void listAllMatchups() {
        List<Matchup> matchups = matchupDao.getAllMatchups();
        matchupView.displayMatchupList(matchups);
    }

    public void createNewMatchup() {
        Matchup matchup = matchupView.getNewMatchupDetails();
        matchupDao.addMatchup(matchup);
        System.out.println("Nuevo enfrentamiento añadido con éxito.");
    }
}
