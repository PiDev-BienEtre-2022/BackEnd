package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Questions;

import java.util.List;

public interface IQuestionsService {
    Long addQuestions(Questions question);

    Long modifyQuestions(Questions question);

    void supprimerQuestions(Long idQuestion);

    List<Questions> getQuestions();

    Questions getQuestionById(Long idQuestion);

    void setQuestionsToQuiz(Long idQuestion, Long idQuiz);

}
