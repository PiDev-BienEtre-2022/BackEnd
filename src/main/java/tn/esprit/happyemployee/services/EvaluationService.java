package tn.esprit.happyemployee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.repositories.EvaluaionRepository;

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
}
