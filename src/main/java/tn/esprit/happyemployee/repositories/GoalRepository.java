package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.Goal;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal,Long> {
    public List<Goal> findByStatusTrue();
    public List<Goal> findByEvaluationAndStatusTrue(Evaluation e);

    public List<Goal> findByEvaluationAndCategory(Evaluation e, Category c);

    @Query(value = "select g from Goal g where g.category.domain=:d and g.evaluation.id=:id")
    public List<Goal> findByEvaluationAndDomain(@Param("id") long id, @Param("d") Domain d);

    @Query(value = "select g.category.id , AVG(g.percentage) from Goal g " +
            "where " +
            "g.category.domain!=(SELECT domain FROM User where id=:id) " +
            "and " +
            "g.status = true " +
            "and " +
            "g.evaluation =:eval " +
            "GROUP BY g.category")
    public List<Double[]> findByDifferentDomain(@Param("id") long id, @Param("eval") Evaluation eval);
}
