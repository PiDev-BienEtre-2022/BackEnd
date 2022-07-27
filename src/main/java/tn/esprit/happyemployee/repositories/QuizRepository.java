package tn.esprit.happyemployee.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.happyemployee.entities.Quiz;
import tn.esprit.happyemployee.entities.User;

import java.util.List;

@Repository("QuizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findByIsPublishedTrue();

	List<Quiz> findByCreatedBy(User user);

	@Query("select q from Quiz q where q.name like %?1%")
	List<Quiz> searchByName(String name);

	@Query(nativeQuery = true, value = "SELECT * FROM Quiz q where q.id_quiz=:id LIMIT 1")
	Quiz findOne(@Param("id") Long id);


//	jdbcTemplate.setMaxRows(1);
}
