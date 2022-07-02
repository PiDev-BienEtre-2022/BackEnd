package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.services.EvaluationService;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class evaluationController {
    @Autowired
    EvaluationService agent;

    @GetMapping("/list")
    public List<Evaluation> list_evaluations(){
        return agent.getEvaluations();
    }

    @GetMapping("/{id}")
    public Evaluation get_evaluation(@PathVariable("id") long id){
        return agent.getEvaluationById(id);
    }

    @PostMapping("/add")
    public String add_evaluation(@RequestBody Evaluation evaluation){
        agent.addEvaluation(evaluation);
        return "ok";
    }

    @PutMapping("update/{id}")
    public String update_evaluation(@PathVariable("id") long id, @RequestBody Evaluation evaluation){
        Evaluation old =  agent.getEvaluationById(id);

        old.setDate(evaluation.getDate());
        old.setNote(evaluation.getNote());
        old.setScore(evaluation.getScore());
        old.setStatus(evaluation.getStatus());

        agent.updateEvaluation(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_evaluation(@PathVariable("id") long id){
        agent.deleteEvaluation(id);
        return "ok";
    }
}
