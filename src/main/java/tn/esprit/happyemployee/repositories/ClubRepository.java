package tn.esprit.happyemployee.repositories;

import tn.esprit.happyemployee.entities.Club;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClubRepository extends JpaRepository<Club, Long> {
    
    Club findByTitle(String title);
}