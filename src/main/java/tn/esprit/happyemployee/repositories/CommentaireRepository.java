package tn.esprit.happyemployee.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.happyemployee.entities.Commentaire;


@Repository
public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

}
