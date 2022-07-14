package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.api.EmailSenderService;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.Goal;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.services.EvaluationService;
import tn.esprit.happyemployee.services.GoalService;
import tn.esprit.happyemployee.services.UserService;

import java.util.List;

@RestController
@RequestMapping("/evaluation")
public class evaluationController {
    @Autowired
    EvaluationService agent;
    @Autowired
    EmailSenderService mailer;

    @Autowired
    UserService userService;

    @Autowired
    GoalService goalService;

    @GetMapping("/list")
    public List<Evaluation> list_evaluations(){
        return agent.getEvaluations();
    }

    @GetMapping("/{id}")
    public Evaluation get_evaluation(@PathVariable("id") long id){
        return agent.getEvaluationById(id);
    }

    @PostMapping("/add/{user_id}")
    public String add_evaluation(@PathVariable("user_id") long user_id, @RequestBody Evaluation evaluation){

        Evaluation eval = agent.getCurrentEval(user_id);

        if(eval == null){
            User u = userService.getUserById(user_id);

            System.out.println(u);
            evaluation.setUser(u);

            agent.addEvaluation(evaluation);
            return "ok";
        }
        return "evaluation exist";
    }

    @PutMapping("update/{id}")
    public String update_evaluation(@PathVariable("id") long id, @RequestBody Evaluation evaluation){
        Evaluation old =  agent.getEvaluationById(id);

        old.setComment(evaluation.getComment());
        old.setDate_eval(evaluation.getDate_eval());
        old.setDate_goals((evaluation.getDate_goals()));
        old.setNb_goals_domain(evaluation.getNb_goals_domain());
        old.setNb_goals_other(evaluation.getNb_goals_other());
        old.setMin_per_domain(evaluation.getMin_per_domain());
        old.setValidated(evaluation.getValidated());
        old.setStatus(evaluation.getStatus());
        old.setFinalValidate(evaluation.getFinalValidate());

        if(evaluation.getFinalValidate() == 1){
            List<Goal> list = goalService.getGoalsByEvaluation(old);

            int per = 0;
            int somme = 0;
            for (int i = 0; i < list.size(); i++) {
                somme += list.get(i).getPercentage();
            }

            per = somme / list.size();
            evaluation.setScore(per);
            old.setScore(evaluation.getScore());
        }

        agent.updateEvaluation(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_evaluation(@PathVariable("id") long id){
        agent.deleteEvaluation(id);
        return "ok";
    }


    @GetMapping("/mail")
    public String mail(){
        mailer.send("khouloud.meherzi@esprit.tn", "hello", "test");
        return "ok";
    }

    @GetMapping("/mesEval/{id}")
    public List<Evaluation> mes_evaluations(@PathVariable("id") long id){
        User u = userService.getUserById(id);
        return agent.getEvaluationByUser(u);
    }
}
