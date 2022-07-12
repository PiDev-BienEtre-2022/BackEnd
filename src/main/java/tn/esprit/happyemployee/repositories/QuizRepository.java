package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Quiz;

public interface QuizRepository extends JpaRepository<Quiz,Long> {
}
