package tn.esprit.happyemployee.repositories;

import tn.esprit.happyemployee.entities.Event;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
    
    Event findByTitle(String title);
}