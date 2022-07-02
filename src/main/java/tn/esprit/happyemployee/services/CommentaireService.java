package tn.esprit.happyemployee.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.entities.Commentaire;
import tn.esprit.happyemployee.repositories.CommentaireRepository;

@Service
public class CommentaireService implements ICommentaireService{

	@Autowired
	CommentaireRepository commentaireRepository;
	
	@Override
	public Long addandmodifyCommentaire(Commentaire commentaire) {
		commentaireRepository.save(commentaire);
		return commentaire.getIdCom();
	}

	@Override
	public void supprimerCommentaire(Long commentaireId) {
		commentaireRepository.deleteById(commentaireId);
		
	}

	@Override
	public List<Commentaire> listCommentaires() {
		return commentaireRepository.findAll();
	}

	@Override
	public Commentaire getCommentaireById(Long id) {
		Optional<Commentaire> comResponse = commentaireRepository.findById(id);
		Commentaire com =  comResponse.get();
		return com;
	}

}
