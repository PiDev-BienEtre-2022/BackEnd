package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Training;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.repositories.TrainingRepository;

import java.util.List;

@Service
public class TrainingService implements ITrainingService{

    @Autowired
    TrainingRepository trainingRepository;
    @Override
    public void addTraining(Training training) {
        trainingRepository.save(training);
    }

    @Override
    public void updateTraining(Training training) {
        trainingRepository.save(training);
    }

    @Override
    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    @Override
    public List<Training> getTrainings() {
        return trainingRepository.findByStatusTrue();
    }

    @Override
    public Training getTrainingById(Long id) {
        return trainingRepository.findById(id).get();
    }

    @Override
    public List<Training> getTrainingsByCategory(Category c){
        return trainingRepository.findByCategory(c);
    }

    @Override
    public List<Training> getTrainingsByUserDomain(Long id){
        return trainingRepository.findByUserDomain(id);
    }

}
