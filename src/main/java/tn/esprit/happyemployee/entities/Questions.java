package tn.esprit.happyemployee.entities;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String textquestion;

    private CategorieQuestion categorieQuestion;

    private string reponseCorrect;

    private string reponsefausse1;

    private string reponsefausse2;

    private string reponsefausse3;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTextquestion() {
        return textquestion;
    }

    public void setTextquestion(String textquestion) {
        this.textquestion = textquestion;
    }

    public CategorieQuestion getCategorieQuestion() {
        return categorieQuestion;
    }

    public void setCategorieQuestion(CategorieQuestion categorieQuestion) {
        this.categorieQuestion = categorieQuestion;
    }

    public string getReponseCorrect() {
        return reponseCorrect;
    }

    public void setReponseCorrect(string reponseCorrect) {
        this.reponseCorrect = reponseCorrect;
    }

    public string getReponsefausse1() {
        return reponsefausse1;
    }

    public void setReponsefausse1(string reponsefausse1) {
        this.reponsefausse1 = reponsefausse1;
    }

    public string getReponsefausse2() {
        return reponsefausse2;
    }

    public void setReponsefausse2(string reponsefausse2) {
        this.reponsefausse2 = reponsefausse2;
    }

    public string getReponsefausse3() {
        return reponsefausse3;
    }

    public void setReponsefausse3(string reponsefausse3) {
        this.reponsefausse3 = reponsefausse3;
    }

}
