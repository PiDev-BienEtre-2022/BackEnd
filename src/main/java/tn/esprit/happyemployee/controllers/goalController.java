package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.Goal;
import tn.esprit.happyemployee.services.CategoryService;
import tn.esprit.happyemployee.services.EvaluationService;
import tn.esprit.happyemployee.services.GoalService;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class goalController {
    @Autowired
    GoalService agent;

    @Autowired
    CategoryService categoryService;

    @Autowired
    EvaluationService evaluationService;

    @GetMapping("/list")
    public List<Goal> list_goals(){
        return agent.getGoals();
    }

    @GetMapping("/{id}")
    public Goal get_goal(@PathVariable("id") long id){
        return agent.getGoalById(id);
    }

    @PostMapping("/add/{id_eval}/{id_cat}")
    public String add_goal(@PathVariable("id_eval") long id_eval, @PathVariable("id_cat") long id_cat, @RequestBody Goal goal){

        Category cat = categoryService.getCategoryById(id_cat);
        Evaluation eval = evaluationService.getEvaluationById(id_eval);
        goal.setCategory(cat);
        goal.setEvaluation(eval);

        agent.addGoal(goal);
        return "ok";
    }

    @PutMapping("update/{id}/{id_eval}/{id_cat}")
    public String update_goal(@PathVariable("id") long id, @PathVariable("id_eval") long id_eval, @PathVariable("id_cat") long id_cat,@RequestBody Goal goal){
        Goal old =  agent.getGoalById(id);
        Category cat = categoryService.getCategoryById(id_cat);
        Evaluation eval = evaluationService.getEvaluationById(id_eval);
        goal.setCategory(cat);
        goal.setEvaluation(eval);

        old.setCategory(goal.getCategory());
        old.setDescription(goal.getDescription());
        old.setEvaluation(goal.getEvaluation());
        old.setPercentage(goal.getPercentage());
        old.setTitre(goal.getTitre());
        old.setStatus(goal.getStatus());

        agent.updateGoal(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_goal(@PathVariable("id") long id){
        agent.deleteGoal(id);
        return "ok";
    }

    @GetMapping("/GoalsEval/{id}")
    public List<Goal> goals_eval(@PathVariable("id") long id){
        Evaluation eval = evaluationService.getEvaluationById(id);
        return agent.getGoalsByEvaluation(eval);
    }


}
