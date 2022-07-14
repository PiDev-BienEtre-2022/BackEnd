package tn.esprit.happyemployee.services;

import tn.esprit.happyemployee.entities.Reponses;

import java.util.List;

public interface IReponsesService {
     void supprimerReponse(Long idReponses);
     Long addReponses(Reponses reponse);
     List<Reponses> getReponses();
     Reponses getReponsesById(Long idReponses);
     void affecterEquipeADepartement(Long idReponses, Long idQuiz);
  //   void affecterUserAEquipe(Long userId, Long idReponses);
}