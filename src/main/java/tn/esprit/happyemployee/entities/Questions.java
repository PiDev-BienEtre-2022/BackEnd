package tn.esprit.happyemployee.entities;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import tn.esprit.happyemployee.domain.enums.CategorieQuestion;


@Entity
@Table(name="questions")
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idQuestion;
    @NotBlank
    private String textquestion;
    @NotBlank
    private CategorieQuestion categorieQuestion;
    @NotBlank
    private String reponseCorrect;
    @NotBlank
    private String reponsefausse1;

    private String reponsefausse2;

    private String reponsefausse3;

    public long getId() {
        return idQuestion;
    }

    public void setId(long id) {
        this.idQuestion = id;
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

    public String getReponseCorrect() {
        return reponseCorrect;
    }

    public void setReponseCorrect(String reponseCorrect) {
        this.reponseCorrect = reponseCorrect;
    }

    public String getReponsefausse1() {
        return reponsefausse1;
    }

    public void setReponsefausse1(String reponsefausse1) {
        this.reponsefausse1 = reponsefausse1;
    }

    public String getReponsefausse2() {
        return reponsefausse2;
    }

    public void setReponsefausse2(String reponsefausse2) {
        this.reponsefausse2 = reponsefausse2;
    }

    public String getReponsefausse3() {
        return reponsefausse3;
    }

    public void setReponsefausse3(String reponsefausse3) {
        this.reponsefausse3 = reponsefausse3;
    }
    @ManyToOne
    @JoinColumn(name="idQuiz", nullable=true)
    private Quiz quiz;

    public long getIdQuestion() {
        return idQuestion;
    }

    public void setIdQuestion(long idQuestion) {
        this.idQuestion = idQuestion;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }
}
