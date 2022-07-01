package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.Event;
import tn.esprit.happyemployee.repositories.EventRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventService {
    
    @Autowired
    private EventRepository eventRepository;

    public List<Event> findAll() {
        return eventRepository.findAll();
    }

    public Event findById(long id) {
        return eventRepository.findById(id).get();
    }

    public Event save(Event event) {
       return eventRepository.save(event);
    }

    public void delete(Event event) {
    	eventRepository.delete(event);
    }
}