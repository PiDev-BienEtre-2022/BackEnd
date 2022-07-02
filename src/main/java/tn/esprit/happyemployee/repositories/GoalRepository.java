package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Goal;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal,Long> {
    public List<Goal> findByStatusTrue();

}
