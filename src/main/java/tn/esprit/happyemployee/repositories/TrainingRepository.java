package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Training;

import java.util.List;

public interface TrainingRepository extends JpaRepository<Training,Long> {
    public List<Training> findByStatusTrue();

}
