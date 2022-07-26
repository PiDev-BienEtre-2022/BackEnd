package tn.esprit.happyemployee.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.repositories.UserRepository;
import tn.esprit.happyemployee.services.IDemandeTeleTravailService;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class DemandeTeleTravailController {

	@Autowired
	IDemandeTeleTravailService demandeTeleTravailService;
	
	@Autowired
	UserRepository userRepository;

	@PostMapping("/ajouterDemande/{userId}")
	@ResponseBody
	public DemandeTeleTravail ajouterDemande(@PathVariable("userId") Long userId,@RequestBody DemandeTeleTravail demande) {
		demandeTeleTravailService.addDemandeTeleTravail(demande, userId);
		return demande;
	}

	@PutMapping("/modifierDemande")
	@ResponseBody
	public DemandeTeleTravail modifierDemande(@RequestBody DemandeTeleTravail demande) {
		demandeTeleTravailService.modifierDemandeTeleTravail(demande);
		return demande;
	}

	@DeleteMapping("/supprimerDemande/{demandeId}")
	@ResponseBody
	public void supprimerDemande(@PathVariable("demandeId") Long demandeId) {
		demandeTeleTravailService.supprimerDemandeTeleTravail(demandeId);

	}

	@GetMapping("/listeDemande")
	@ResponseBody
	public List<DemandeTeleTravail> listeDemande() {

		return  demandeTeleTravailService.getDemandeTeleTravails();
	}
	
	@GetMapping("/listeDemandeByEquipe/equipeId")
	@ResponseBody
	public List<DemandeTeleTravail> listeDemandeFilter(@PathVariable("equipeId") Long equipeId) {
		return  demandeTeleTravailService.getDemandeTeleTravailsByEquipeId(equipeId);
	}
	
	@GetMapping("/getDemande/{demandeId}")
	@ResponseBody
	public DemandeTeleTravail getDemande(@PathVariable("demandeId") Long demandeId) {

		return  demandeTeleTravailService.getDemandeTeleTravailById(demandeId);
	}
	
	@GetMapping("/getDemandesByUser/{userId}")
	@ResponseBody
	public  List<DemandeTeleTravail> getDemandeByUser(@PathVariable("userId") Long userId) {

		
		return  demandeTeleTravailService.getDemandebyUser(userId);
	}
}
