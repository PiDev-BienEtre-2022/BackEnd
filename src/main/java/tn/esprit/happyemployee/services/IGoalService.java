package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Goal;

import java.util.List;

public interface IGoalService {
    void addGoal(Goal goal);
    void updateGoal(Goal goal);
    void deleteGoal(Long id);
    List<Goal> getGoals();
    Goal getGoalById(Long id);
}
