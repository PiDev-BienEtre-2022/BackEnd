package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.User;

import java.util.List;

public interface EvaluaionRepository extends JpaRepository<Evaluation,Long> {
    public List<Evaluation> findByStatusTrue();
    public List<Evaluation> findByUser(User u);
    @Query(value = "select * from Evaluation e where user.id =:id and finalValidate = 0", nativeQuery = true)
    public Evaluation findByUserAndNotValidated(@Param("id") long id);

    @Query(value = "select * from Evaluation e where id_user=:id and finalValidate = 1 order By dateEval LIMIT 1", nativeQuery = true)
    public Evaluation findByLastEval(@Param("id") long id);
}
