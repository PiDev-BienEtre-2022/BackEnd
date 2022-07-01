package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.happyemployee.entities.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Long> {

}
