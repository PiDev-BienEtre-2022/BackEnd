package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.Club;
import tn.esprit.happyemployee.repositories.ClubRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClubService {
    
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> findAll() {
        return clubRepository.findAll();
    }

    public Club findById(long id) {
        return clubRepository.findById(id).get();
    }

    public Club save(Club club) {
       return clubRepository.save(club);
    }

    public void delete(Club club) {
    	clubRepository.delete(club);
    }
}