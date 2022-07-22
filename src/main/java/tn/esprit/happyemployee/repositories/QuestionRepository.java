package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.happyemployee.entities.Question;
import tn.esprit.happyemployee.entities.Quiz;

import java.util.List;

@Repository("QuestionRepository")
public interface QuestionRepository extends JpaRepository<Question, Long> {
	int countByQuiz(Quiz quiz);

	int countByQuizAndIsValidTrue(Quiz quiz);

	List<Question> findByQuizOrderByOrderAsc(Quiz quiz);

	List<Question> findByQuizAndIsValidTrueOrderByOrderAsc(Quiz quiz);

	@Query(nativeQuery = true, value = "SELECT p FROM Question p LIMIT 1")
	Question findOne(Long id);
}
