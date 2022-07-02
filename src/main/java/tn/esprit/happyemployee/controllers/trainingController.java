package tn.esprit.happyemployee.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.happyemployee.entities.Training;
import tn.esprit.happyemployee.services.TrainingService;

import java.util.List;

@RestController
@RequestMapping("/training")
public class trainingController {
    @Autowired
    TrainingService agent;

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

}
