package tn.esprit.happyemployee.services;

import java.util.List;
import tn.esprit.happyemployee.entities.*;

public interface IEquipeService {

	Long addEquipe(Equipe equipe);

	Long modifierEquipe(Equipe equipe);

	void supprimerEquipe(Long equipeId);
	
	List<Equipe> getEquipes();
	
	Equipe getEquipeById(Long equipeId);
	
	void affecterEquipeADepartement(Long equipeId, Long departementId);
}