package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.happyemployee.entities.Theme;


@Repository
public interface ThemeRepository extends JpaRepository<Theme, Long>{

}
