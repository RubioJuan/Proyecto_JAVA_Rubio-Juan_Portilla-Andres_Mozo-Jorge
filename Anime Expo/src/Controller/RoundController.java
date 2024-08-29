/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.RoundDao;
import Model.Round;
import View.RoundView;

import java.util.List;

public class RoundController {
    private RoundDao roundDao;
    private RoundView roundView;

    public RoundController(RoundDao roundDao, RoundView roundView) {
        this.roundDao = roundDao;
        this.roundView = roundView;
    }

    public void listAllRounds() {
        List<Round> rounds = roundDao.getAllRounds();
        roundView.displayRoundList(rounds);
    }

    public void createNewRound() {
        Round round = roundView.getNewRoundDetails();
        roundDao.addRound(round);
        System.out.println("Nueva ronda añadida con éxito.");
    }
}
