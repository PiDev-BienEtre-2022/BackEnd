package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Evaluation;

import java.util.List;

public interface EvaluaionRepository extends JpaRepository<Evaluation,Long> {
    public List<Evaluation> findByStatusTrue();

}
