package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Evaluation;

import java.util.List;

public interface IEvaluationService {
    void addEvaluation(Evaluation evaluation);
    void updateEvaluation(Evaluation evaluation);
    void deleteEvaluation(Long id);
    List<Evaluation> getEvaluations();
    Evaluation getEvaluationById(Long id);
}
