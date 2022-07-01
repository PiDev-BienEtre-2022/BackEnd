package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.happyemployee.entities.Category;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
