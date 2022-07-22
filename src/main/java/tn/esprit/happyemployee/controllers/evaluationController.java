package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.api.EmailSenderService;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.Goal;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.services.EvaluationService;
import tn.esprit.happyemployee.services.GoalService;
import tn.esprit.happyemployee.services.UserService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@EnableWebSecurity
@CrossOrigin
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

            evaluation.setUser(u);
            evaluation.setStatus(true);
            evaluation.setValidated(0);
            evaluation.setFinalValidate(0);

            agent.addEvaluation(evaluation);
            return "ok";
        }
        return "Evaluation exist !";
    }

    @PutMapping("update/{id}")
    public String update_evaluation(@PathVariable("id") long id, @RequestBody Evaluation evaluation){
        Evaluation old =  agent.getEvaluationById(id);

        old.setComment(evaluation.getComment());
        old.setDate_eval(evaluation.getDate_eval());
        old.setDate_goals((evaluation.getDate_goals()));
        old.setMin_per_domain(evaluation.getMin_per_domain());
        old.setValidated(evaluation.getValidated());
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
        //agent.deleteEvaluation(id);

        Evaluation old =  agent.getEvaluationById(id);
        old.setStatus(false);

        agent.updateEvaluation(old);


        return "ok";

    }


    @Scheduled(cron = "0 0 08 * * *" , zone = "Europe/Paris")
    @GetMapping("/mail")
    public void mail(){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        List<Evaluation> list = agent.getWithLocalDate(formatter.format(date));
        for (int i = 0; i < list.size(); i++) {
            List<Goal> listGoals = goalService.getGoalsByEvaluation(list.get(i));
            if(listGoals.isEmpty()){
                String email = list.get(i).getUser().getEmail();
                String body = "Hello" + list.get(i).getUser().getUsername() +
                        ", You have a validation session today"
                        + formatter.format(date)
                        + "and you didn't achieve your goals." +
                        "Have a good day :)";
                String Subject = "Reminder - No Reply";
                mailer.send(email, body, Subject);
            }
        }
    }

    @GetMapping("/mesEval/{id}")
    public List<Evaluation> mes_evaluations(@PathVariable("id") long id){
        User u = userService.getUserById(id);
        return agent.getEvaluationByUser(u);
    }

    @GetMapping("/notValidated")
    public List<Evaluation> not_validated(){
        return agent.getEvaluationValidated(0);
    }

    @GetMapping("/inProgress")
    public List<Evaluation> in_progress(){
        return agent.getEvaluationFinalValidated(0);
    }

    @GetMapping("/Validated")
    public List<Evaluation> Validated(){
        return agent.getEvaluationFinalValidated(1);
    }

    @GetMapping("/mesValidatedEval/{id}")
    public List<Evaluation> validated_eval(@PathVariable("id") long id){
        return agent.getUserValidatedEval(id);
    }

    @GetMapping("/currentEval/{id}")
    public Evaluation currentEval(@PathVariable("id") long id){
        return agent.getCurrentEval(id);
    }

    @GetMapping("/validate/{id}")
    public String validateEval(@PathVariable("id") long id){
        Evaluation old =  agent.getEvaluationById(id);
        old.setValidated(1);
        agent.updateEvaluation(old);
        return "ok";
    }
}
