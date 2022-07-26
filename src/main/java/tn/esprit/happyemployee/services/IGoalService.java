package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.Goal;

import java.util.List;

public interface IGoalService {
    void addGoal(Goal goal);
    void updateGoal(Goal goal);
    void deleteGoal(Long id);
    List<Goal> getGoals();
    Goal getGoalById(Long id);
    List<Goal> getGoalsByEvaluation(Evaluation e);

    List<Goal> getGoalsEvalAndCategory(Evaluation e, Category c);

    List<Goal> getGoalsEvalAndDomain(Long id, Domain d);
    List<Double[]> getDifferentDomain(Long id, Evaluation eval);
    Double stat(Long id, Domain d);

}
