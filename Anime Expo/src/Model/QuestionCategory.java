/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class QuestionCategory {
    private int idCategory;
    private String categoryName;

    public QuestionCategory(int idCategory, String categoryName) {
        this.idCategory = idCategory;
        this.categoryName = categoryName;
    }

    // Getters y setters
    public int getIdCategory() { return idCategory; }
    public void setIdCategory(int idCategory) { this.idCategory = idCategory; }
    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    @Override
    public String toString() {
        return "QuestionCategory{" +
                "idCategory=" + idCategory +
                ", categoryName='" + categoryName + '\'' +
                '}';
    }
}
