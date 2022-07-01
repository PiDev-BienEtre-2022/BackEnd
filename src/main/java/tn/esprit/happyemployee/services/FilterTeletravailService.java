package tn.esprit.happyemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.happyemployee.repositories.DepartementRepository;
import tn.esprit.happyemployee.repositories.EquipeRepository;
import tn.esprit.happyemployee.repositories.FilterTeletravailRepository;
import tn.esprit.happyemployee.entities.Departement;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.FilterTeletravail;

@Service
public class FilterTeletravailService implements IFilterTeletravailService {

	@Autowired
	FilterTeletravailRepository filterTeletravailRepository;
	@Autowired
	DepartementRepository departementRepository;
	@Autowired
	EquipeRepository equipeRepository;
	
	@Override
	public Long addFilterTeletravail(FilterTeletravail filterTeletravail) {
		filterTeletravailRepository.save(filterTeletravail);
		return filterTeletravail.getId();
	}

	@Override
	public Long modifierFilterTeletravail(FilterTeletravail filterTeletravail) {
		filterTeletravailRepository.save(filterTeletravail);
		return filterTeletravail.getId();
	}

	@Override
	public void supprimerFilterTeletravail(Long filterTeletravailId) {
		filterTeletravailRepository.deleteById(filterTeletravailId);
	}

	@Override
	public List<FilterTeletravail> getFilterTeletravails() {
		return filterTeletravailRepository.findAll();
	}

	@Override
	public FilterTeletravail getFilterTeletravailById(Long filterTeletravailId) {
		return filterTeletravailRepository.findById(filterTeletravailId).get();
	}

	@Override
	public void affecterFiltreADepartement(Long filtreId, Long departementId) {
		Departement departement = departementRepository.findById(departementId).get();
		FilterTeletravail filter = filterTeletravailRepository.findById(filtreId).get();		
		if(departement != null && filter != null ) {
			departement.setFiltre(filter);
			departementRepository.save(departement);
		}
	}

	@Override
	public void affecterFiltreAEquipe(Long filtreId, Long equipeId) {
		Equipe equipe = equipeRepository.findById(equipeId).get();
		FilterTeletravail filter = filterTeletravailRepository.findById(filtreId).get();		
		if(equipe != null && filter != null ) {
			equipe.setFiltre(filter);
			equipeRepository.save(equipe);
		}
	}

}
