package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Training;
import tn.esprit.happyemployee.entities.User;

import java.util.List;

public interface ITrainingService {
    void addTraining(Training training);
    void updateTraining(Training training);
    void deleteTraining(Long id);
    List<Training> getTrainings();
    Training getTrainingById(Long id);
    List<Training> getTrainingsByCategory(Category c);
    List<Training> getTrainingsByUserDomain(Long id);
}
