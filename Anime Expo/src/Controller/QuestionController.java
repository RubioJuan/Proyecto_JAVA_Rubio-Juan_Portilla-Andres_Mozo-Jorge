/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;


import Dao.QuestionDao;
import Model.Question;
import View.QuestionView;

import java.util.List;

public class QuestionController {
    private QuestionDao questionDao;
    private QuestionView questionView;

    public QuestionController(QuestionDao questionDao, QuestionView questionView) {
        this.questionDao = questionDao;
        this.questionView = questionView;
    }

    public void listAllQuestions() {
        List<Question> questions = questionDao.getAllQuestions();
        questionView.displayQuestionList(questions);
    }

    public void createNewQuestion() {
        Question question = questionView.getNewQuestionDetails();
        questionDao.addQuestion(question);
        System.out.println("Nueva pregunta añadida con éxito.");
    }
}
