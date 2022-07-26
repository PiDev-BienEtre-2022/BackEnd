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
    @Query(value = "SELECT training.id, training.date, training.label , training.nbParticipant, training.place, training.ID_Category, training.status " +
            "FROM `training` , `category`, `users` " +
            "WHERE " +
            "training.id_category = category.id " +
            "and " +
            "users.domain = category.domain and users.id =:id " +
            "and " +
            "training.status = true " +
            "order by training.date" , nativeQuery = true)
    public List<Training> findByUserDomain(@Param("id")  long id);

}
