package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.User;

import java.util.Date;
import java.util.List;

public interface IEvaluationService {
    void addEvaluation(Evaluation evaluation);
    void updateEvaluation(Evaluation evaluation);
    void deleteEvaluation(Long id);
    List<Evaluation> getEvaluations();
    Evaluation getEvaluationById(Long id);

    List<Evaluation> getEvaluationByUser(User u);

   Evaluation getCurrentEval(long id);
    Evaluation getLastEval(long id);

    List<Evaluation> getEvaluationValidated(int val);

    List<Evaluation> getEvaluationFinalValidated(int val);

    List<Evaluation> getUserValidatedEval(long id);
    List<Evaluation> getWithLocalDate(String d);
}
