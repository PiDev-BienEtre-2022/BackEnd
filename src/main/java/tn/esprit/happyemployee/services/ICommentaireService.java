package tn.esprit.happyemployee.services;

import java.util.List;

import tn.esprit.happyemployee.entities.Commentaire;


public interface ICommentaireService {

	Long addandmodifyCommentaire(Commentaire commentaire);

	void supprimerCommentaire(Long commentaireId);

	List<Commentaire> listCommentaires();

	Commentaire getCommentaireById(Long id);

	//Long nombrePublicationsParTheme();
}
