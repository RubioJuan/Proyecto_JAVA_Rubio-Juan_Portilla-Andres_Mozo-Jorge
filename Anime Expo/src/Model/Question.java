/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class Question {
    private int idQuestion;
    private String questionText;
    private String correctAnswer;
    private String category;
    private String difficulty;

    public Question(int idQuestion, String questionText, String correctAnswer, String category, String difficulty) {
        this.idQuestion = idQuestion;
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.category = category;
        this.difficulty = difficulty;
    }

    public int getIdQuestion() { return idQuestion; }
    public void setIdQuestion(int idQuestion) { this.idQuestion = idQuestion; }
    public String getQuestionText() { return questionText; }
    public void setQuestionText(String questionText) { this.questionText = questionText; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("╔════════════════════════════════════════════════════════════════════════════════════╗\n");
        sb.append("                                    Question Details                                   \n");
        sb.append("╠════════════════════════════════════════════════════════════════════════════════════╣\n");
        sb.append(String.format("║ ID Question         : %-45d \n", idQuestion));
        sb.append(String.format("║ Question Text       : %-45s \n", questionText));
        sb.append(String.format("║ Correct Answer      : %-45s \n", correctAnswer));
        sb.append(String.format("║ Category            : %-45s \n", category));
        sb.append(String.format("║ Difficulty          : %-45s \n", difficulty));
        sb.append("╚════════════════════════════════════════════════════════════════════════════════════╝");
        return sb.toString();
    }
}
