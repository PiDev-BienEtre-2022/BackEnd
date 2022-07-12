package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Questions;

public interface QuestionsRepository  extends JpaRepository<Questions,Long> {
}
