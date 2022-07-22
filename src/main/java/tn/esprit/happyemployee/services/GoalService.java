package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.Goal;
import tn.esprit.happyemployee.repositories.GoalRepository;

import java.util.List;

@Service
public class GoalService implements IGoalService{

    @Autowired
    GoalRepository goalRepository;
    @Override
    public void addGoal(Goal goal) {
        goalRepository.save(goal);
    }

    @Override
    public void updateGoal(Goal goal) {
        goalRepository.save(goal);
    }

    @Override
    public void deleteGoal(Long id) {
        goalRepository.deleteById(id);
    }

    @Override
    public List<Goal> getGoals() {
        return goalRepository.findByStatusTrue();
    }

    @Override
    public Goal getGoalById(Long id) {
        return goalRepository.findById(id).get();
    }

    @Override
    public List<Goal> getGoalsByEvaluation(Evaluation e) {
        return goalRepository.findByEvaluationAndStatusTrue(e);
    }

    @Override
    public List<Goal> getGoalsEvalAndCategory(Evaluation e, Category c){
        return goalRepository.findByEvaluationAndCategory(e, c);
    }

    @Override
    public List<Goal> getGoalsEvalAndDomain(Long id, Domain d){
        return goalRepository.findByEvaluationAndDomain(id, d);
    }

    @Override
    public List<Double[]> getDifferentDomain(Long id, Evaluation eval){
        return goalRepository.findByDifferentDomain(id, eval);
    }
}
