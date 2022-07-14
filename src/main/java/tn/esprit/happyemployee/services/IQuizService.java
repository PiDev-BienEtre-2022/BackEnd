package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Quiz;

import java.util.List;

public interface IQuizService {
    Long addQuiz(Quiz quiz);

    Long modifyQuiz(Quiz quiz);

    void supprimerQuiz(Long idQuiz);

    List<Quiz> getQuiz();

    Quiz getQuizById(Long idQuiz);

    void getQuestionToQuiz(Long idQuestion, Long idQuiz);

}
