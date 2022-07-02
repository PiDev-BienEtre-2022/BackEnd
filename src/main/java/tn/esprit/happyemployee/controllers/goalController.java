package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Goal;
import tn.esprit.happyemployee.services.GoalService;

import java.util.List;

@RestController
@RequestMapping("/goal")
public class goalController {
    @Autowired
    GoalService agent;

    @GetMapping("/list")
    public List<Goal> list_goals(){
        return agent.getGoals();
    }

    @GetMapping("/{id}")
    public Goal get_goal(@PathVariable("id") long id){
        return agent.getGoalById(id);
    }

    @PostMapping("/add")
    public String add_goal(@RequestBody Goal goal){
        agent.addGoal(goal);
        return "ok";
    }

    @PutMapping("update/{id}")
    public String update_goal(@PathVariable("id") long id, @RequestBody Goal goal){
        Goal old =  agent.getGoalById(id);

        old.setCategory(goal.getCategory());
        old.setDescription(goal.getDescription());
        old.setEvaluation(goal.getEvaluation());
        old.setPercentage(goal.getPercentage());
        old.setTitre(goal.getTitre());
        old.setValidate(goal.getValidate());
        old.setStatus(goal.getStatus());

        agent.updateGoal(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_goal(@PathVariable("id") long id){
        agent.deleteGoal(id);
        return "ok";
    }
}
