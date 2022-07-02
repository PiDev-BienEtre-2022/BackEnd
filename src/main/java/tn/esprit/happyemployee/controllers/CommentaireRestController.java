package tn.esprit.happyemployee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.happyemployee.entities.Commentaire;
import tn.esprit.happyemployee.services.ICommentaireService;

@RestController
public class CommentaireRestController {

	@Autowired
	ICommentaireService commentaireService;

	@GetMapping("/Commentaires")
	@ResponseBody
	public List<Commentaire> getAllThemes() {
		List<Commentaire> list = commentaireService.listCommentaires();
		return list;
	}

	@PostMapping("/ajouterCommentaire")
	@ResponseBody
	public Commentaire ajouterCommentaire(@RequestBody Commentaire commentaire) {
		commentaireService.addandmodifyCommentaire(commentaire);
		return commentaire;
	}
	
	@PutMapping("/modifierCommentaire")
	@ResponseBody
	public Commentaire modifierCommentaire(@RequestBody Commentaire commentaire) {
		commentaireService.addandmodifyCommentaire(commentaire);
		return commentaire;
	}
	
	@DeleteMapping("/supprimerCommentaire/{commentaireId}")
	@ResponseBody
	public void supprimerCommentaire(@PathVariable("commentaireId") Long commentaireId) {
		commentaireService.supprimerCommentaire(commentaireId);
	}
	
}
