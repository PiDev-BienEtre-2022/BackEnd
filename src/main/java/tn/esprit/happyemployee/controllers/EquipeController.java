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
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.services.IEquipeService;



@RestController
public class EquipeController {

	@Autowired
	IEquipeService equipeService;

	@PostMapping("/ajouterEquipe")
	@ResponseBody
	public Equipe ajouterEquipe(@RequestBody Equipe equipe) {
		equipeService.addEquipe(equipe);
		return equipe;
	}

	@PutMapping("/modifierEquipe")
	@ResponseBody
	public Equipe modifierEquipe(@RequestBody Equipe equipe) {
		equipeService.modifierEquipe(equipe);
		return equipe;
	}

	@DeleteMapping("/supprimerEquipe/{equipeId}")
	@ResponseBody
	public void supprimerEquipe(@PathVariable("equipeId") Long equipeId) {
		equipeService.supprimerEquipe(equipeId);

	}

	@GetMapping("/listeEquipe")
	@ResponseBody
	public List<Equipe> listeEquipe() {

		return  equipeService.getEquipes();
	}
	
	@GetMapping("/getEquipe/{equipeId}")
	@ResponseBody
	public Equipe getEquipe(@PathVariable("equipeId") Long equipeId) {

		return  equipeService.getEquipeById(equipeId);
	}
	
	@PutMapping("/affecterEquipeADepartement/{equipeId}/{departementId}")
	@ResponseBody
	public String affecterEquipeADepartement(@PathVariable("equipeId")  Long equipeId, @PathVariable("departementId") Long departementId) {
		equipeService.affecterEquipeADepartement(equipeId, departementId);
		return "equipe affecté correctement";
	}
	
	@PutMapping("/affecterUserAEquipe/{userId}/{equipeId}")
	@ResponseBody
	public String affecterUserAEquipe(@PathVariable("userId")  Long userId, @PathVariable("equipeId") Long equipeId) {
		equipeService.affecterUserAEquipe(userId, equipeId);
		return "user affecté correctement";
	}
}

