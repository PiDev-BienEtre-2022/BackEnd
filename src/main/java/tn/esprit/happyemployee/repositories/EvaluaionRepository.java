package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.happyemployee.entities.Evaluation;
import tn.esprit.happyemployee.entities.User;

import java.util.Date;
import java.util.List;

public interface EvaluaionRepository extends JpaRepository<Evaluation,Long> {
    public List<Evaluation> findByStatusTrue();

    public List<Evaluation> findByUser(User u);

    @Query(value = "select * from Evaluation e where CAST(date_goals AS DATE)  =:d and status = true", nativeQuery = true)
    public List<Evaluation> findByDate_goalsAndStatusTrue(@Param("d") String d);
    @Query(value = "select * from Evaluation e where id_user =:id and finalValidate = 0 and status = true", nativeQuery = true)
    public Evaluation findByUserAndNotValidated(@Param("id") long id);

    @Query(value = "select * from Evaluation e where id_user =:id and finalValidate = 1 and status = true", nativeQuery = true)
    public List<Evaluation>  findByUserAndValidated(@Param("id") long id);



    @Query(value = "select * from Evaluation e where id_user=:id and finalValidate = 1 and status = true order By date_eval DESC LIMIT 1", nativeQuery = true)
    public Evaluation findByLastEval(@Param("id") long id);


    public List<Evaluation> findByValidatedAndStatusTrue(int val);

    @Query(value = "select * from Evaluation e where finalValidate=:val and validated = 1 and status = true", nativeQuery = true)
    public List<Evaluation> findByFinalValidated(@Param("val") int val);

}
