package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.repositories.EvaluaionRepository;

import java.util.Date;
import java.util.List;

@Service
public class EvaluationService implements IEvaluationService{

    @Autowired
    EvaluaionRepository evaluaionRepository;
    @Override
    public void addEvaluation(Evaluation evaluation) {
        evaluaionRepository.save(evaluation);
    }

    @Override
    public void updateEvaluation(Evaluation evaluation) {
        evaluaionRepository.save(evaluation);
    }

    @Override
    public void deleteEvaluation(Long id) {
        evaluaionRepository.deleteById(id);
    }

    @Override
    public List<Evaluation> getEvaluations() {
        return evaluaionRepository.findByStatusTrue();
    }

    @Override
    public Evaluation getEvaluationById(Long id) {
        return evaluaionRepository.findById(id).get();
    }

    @Override
    public List<Evaluation> getEvaluationByUser(User u) {
        return evaluaionRepository.findByUser(u);
    }
    @Override
    public Evaluation getCurrentEval(long id){
        return evaluaionRepository.findByUserAndNotValidated(id);
    }

    @Override
    public Evaluation getLastEval(long id){
        return evaluaionRepository.findByLastEval(id);
    }

    @Override
    public List<Evaluation> getEvaluationValidated(int val) {
        return evaluaionRepository.findByValidatedAndStatusTrue(val);
    }

    @Override
    public List<Evaluation> getEvaluationFinalValidated(int val) {
        return evaluaionRepository.findByFinalValidated(val);
    }

    @Override
    public List<Evaluation> getUserValidatedEval(long id){
        return evaluaionRepository.findByUserAndValidated(id);
    }


    @Override
    public List<Evaluation> getWithLocalDate(String d){
        return evaluaionRepository.findByDate_goalsAndStatusTrue(d);
    }


}
