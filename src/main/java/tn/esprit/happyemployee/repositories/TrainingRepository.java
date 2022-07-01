package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Training;

public interface TrainingRepository extends JpaRepository<Training,Long> {
}
