package tn.esprit.happyemployee.services;

import java.util.List;
import tn.esprit.happyemployee.entities.*;

public interface IEquipeService {

	Long addEquipe(Equipe equipe);

	Long modifierCours(Equipe equipe);

	void supprimerEquipe(Long equipeId);
	
	List<Equipe> getEquipes();
	
	Equipe getEquipeById(Long equipeId);
}
