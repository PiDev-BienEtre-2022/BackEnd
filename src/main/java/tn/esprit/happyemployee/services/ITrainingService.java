package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Training;

import java.util.List;

public interface ITrainingService {
    void addTraining(Training training);
    void updateTraining(Training training);
    void deleteTraining(Long id);
    List<Training> getTrainings();
    Training getTrainingById(Long id);
}
