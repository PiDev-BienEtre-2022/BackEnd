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
import tn.esprit.happyemployee.entities.Departement;
import tn.esprit.happyemployee.services.IDepartementService;



@RestController
public class DepartementController {

	@Autowired
	IDepartementService departementService;

	@PostMapping("/ajouterDepartement")
	@ResponseBody
	public Departement ajouterDepartement(@RequestBody Departement departement) {
		departementService.addDepartement(departement);
		return departement;
	}

	@PutMapping("/modifierDepartement")
	@ResponseBody
	public Departement modifierDepartement(@RequestBody Departement departement) {
		departementService.modifierDepartement(departement);
		return departement;
	}

	@DeleteMapping("/supprimerDepartement/{departementId}")
	@ResponseBody
	public void supprimerDepartement(@PathVariable("departementId") Long departementId) {
		departementService.supprimerDepartement(departementId);

	}

	@GetMapping("/listeDepartement")
	@ResponseBody
	public List<Departement> listeDepartement() {

		return  departementService.getDepartements();
	}
	
	@GetMapping("/getDepartement/{departementId}")
	@ResponseBody
	public Departement getDepartement(@PathVariable("departementId") Long departementId) {

		return  departementService.getDepartementById(departementId);
	}
}

