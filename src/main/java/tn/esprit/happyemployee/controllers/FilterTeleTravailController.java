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
import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.services.IFilterTeletravailService;



@RestController
public class FilterTeleTravailController {

	@Autowired
	IFilterTeletravailService filterTeleTravailService;

	@PostMapping("/ajouterFilter")
	@ResponseBody
	public FilterTeletravail ajouterFilter(@RequestBody FilterTeletravail filter) {
		filterTeleTravailService.addFilterTeletravail(filter);
		return filter;
	}

	@PutMapping("/modifierFilter")
	@ResponseBody
	public FilterTeletravail modifierFilter(@RequestBody FilterTeletravail filter) {
		filterTeleTravailService.modifierFilterTeletravail(filter);
		return filter;
	}

	@DeleteMapping("/supprimerFilter/{filterId}")
	@ResponseBody
	public void supprimerFilter(@PathVariable("filterId") Long filterId) {
		filterTeleTravailService.supprimerFilterTeletravail(filterId);

	}

	@GetMapping("/listeFilter")
	@ResponseBody
	public List<FilterTeletravail> listeFilter() {

		return  filterTeleTravailService.getFilterTeletravails();
	}
	
	@GetMapping("/getFilter/{filterId}")
	@ResponseBody
	public FilterTeletravail getFilter(@PathVariable("filterId") Long filterId) {

		return  filterTeleTravailService.getFilterTeletravailById(filterId);
	}
	
	@PutMapping("/affecterFiltreAEquipe/{filterId}/{equipeId}")
	@ResponseBody
	public String affecterFiltreAEquipe(@PathVariable("filterId")  Long filterId, @PathVariable("equipeId") Long equipeId) {
		filterTeleTravailService.affecterFiltreAEquipe(filterId, equipeId);
		return "filter affecté correctement";
	}
	
	@PutMapping("/affecterFiltreADepartement/{filterId}/{departementId}")
	@ResponseBody
	public String affecterFiltreADepartement(@PathVariable("filterId")  Long filterId, @PathVariable("departementId") Long departementId) {
		filterTeleTravailService.affecterFiltreADepartement(filterId, departementId);
		return "filter affecté correctement";
	}
}

