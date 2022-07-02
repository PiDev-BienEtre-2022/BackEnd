package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.Training;
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
}
