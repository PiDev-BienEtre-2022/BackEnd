package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.happyemployee.domain.enums.Domain;
import tn.esprit.happyemployee.entities.Category;
import tn.esprit.happyemployee.entities.Training;
import tn.esprit.happyemployee.entities.User;

import java.util.List;

public interface
TrainingRepository extends JpaRepository<Training,Long> {
    public List<Training> findByStatusTrue();

    public List<Training> findByCategory(Category c);
    @Query(value = "select * from Training " +
            "where " +
            "((SELECT domain FROM Category INNER JOIN Training ON Category.id = Training.id_category) = (SELECT domain FROM users where id=:id))" +
            " and " +
            "(status = true) order By date", nativeQuery = true)
    public List<Training> findByUserDomain(@Param("id")  long id);

}
