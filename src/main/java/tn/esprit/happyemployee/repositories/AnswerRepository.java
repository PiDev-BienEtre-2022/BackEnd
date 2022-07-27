package tn.esprit.happyemployee.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.happyemployee.entities.Answer;
import tn.esprit.happyemployee.entities.Question;

import java.util.List;

@Repository("AnswerRepository")
public interface AnswerRepository extends JpaRepository<Answer, Long> {

	int countByQuestion(Question question);

	List<Answer> findByQuestionOrderByOrderAsc(Question question);

	@Query(nativeQuery = true, value = "SELECT * FROM Answer a where a.id_answer=:id LIMIT 1")
	Answer findOne(Long id);

}
