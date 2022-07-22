package tn.esprit.happyemployee.controllers;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.*;
import tn.esprit.happyemployee.services.*;

import java.util.List;

@RestController
@RequestMapping("/training")
public class trainingController {
    @Autowired
    TrainingService agent;

    @Autowired
    EvaluationService evaluationService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    GoalService goalService;
    @Autowired
    UserService userService;

    @GetMapping("/list")
    public List<Training> list_trainigs(){
        return agent.getTrainings();
    }

    @GetMapping("/{id}")
    public Training get_training(@PathVariable("id") long id){
        return agent.getTrainingById(id);
    }

    @PostMapping("/add")
    public String add_training(@RequestBody Training training){
        agent.addTraining(training);
        return "ok";
    }

    @PutMapping("update/{id}")
    public String update_training(@PathVariable("id") long id, @RequestBody Training training){
        Training old =  agent.getTrainingById(id);

        old.setCategory(training.getCategory());
        old.setDate(training.getDate());
        old.setLabel(training.getLabel());
        old.setPlace(training.getPlace());
        old.setNbParticipant(training.getNbParticipant());
        old.setStatus(training.getStatus());

        agent.updateTraining(old);
        return "ok";
    }

    @DeleteMapping("/delete/{id}")
    public String delete_training(@PathVariable("id") long id){
        agent.deleteTraining(id);
        return "ok";
    }

    @GetMapping("/category/{id}")
    public List<Training> get_trainings_by_category(@PathVariable("id") long id){
        return agent.getTrainingsByCategory(categoryService.getCategoryById(id));
    }

    @GetMapping("/verif/{id_user}/{id_training}")
    public String verifAccess(@PathVariable("id_user") long id_user, @PathVariable("id_training") long id_training){

        User u = userService.getUserById(id_user);
        Training t = agent.getTrainingById(id_training);

        //IF his domain allowd all
        if(u.getDomain().equals(t.getCategory().getDomain())){
            return "ok";
        } else {
            Evaluation eval = evaluationService.getLastEval(id_user);
            if(eval == null){
                return "no last eval";
            }else{
                List<Goal> listDomain = goalService.getGoalsEvalAndDomain(eval.getId(), u.getDomain());

                int perDomain = 0;
                int sommeDomain = 0;
                for (int i = 0; i < listDomain.size(); i++) {
                    sommeDomain += listDomain.get(i).getPercentage();
                }
                //Calculate percentage of goals domain
                perDomain = sommeDomain / listDomain.size();
                //Verify min per domain
                if(perDomain >= eval.getMin_per_domain()) {

                    List<Goal> list = goalService.getGoalsEvalAndCategory(eval, t.getCategory());
                    int per = 0;
                    int somme = 0;
                    if (!list.isEmpty()) {
                        for (int i = 0; i < list.size(); i++) {
                            somme += list.get(i).getPercentage();
                        }
                        per = somme / list.size();
                    }
                    if (per >= t.getCategory().getPercentage()) {
                        System.out.println("///////////");
                        /*if(t.getNbParticipant() != 0){
                            return "ok";
                        }else{
                            return "sold out!";
                        }*/
                        return "ok";
                    } else {
                        return "Percentage category not enough";
                    }
                }else{
                    return "Percentage domain not enough";
                }
            }
        }
    }

    @GetMapping("/allowedTrainings/{id_user}")
    public List<Training> getAllowedTrainings(@PathVariable("id_user") long id_user) {
        List<Training> list= agent.getTrainingsByUserDomain(id_user);
        Evaluation eval = evaluationService.getLastEval(id_user);
        if(eval != null){
            List<Double[]> goals = goalService.getDifferentDomain(id_user, eval);
            for (int i = 0; i < goals.size(); i++) {
                Category c =  categoryService.getCategoryById(goals.get(i)[0].longValue());
                if(c.getPercentage() <= goals.get(i)[1]){
                    list.addAll(agent.getTrainingsByCategory(c));
                }
            }
         }
         return list;
    }
}
