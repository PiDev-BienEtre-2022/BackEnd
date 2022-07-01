package tn.esprit.happyemployee.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.repositories.DemandeTeleTravailRepository;


@Service
public class DemandeTeleTravailService implements IDemandeTeleTravailService {

	@Autowired
	DemandeTeleTravailRepository demandeTeleTravailRepository;
	
	@Override
	public Long getDemandeTeleTravail(DemandeTeleTravail demande) {
		demandeTeleTravailRepository.save(demande);
		return demande.getId();
	}

	@Override
	public Long modifierDepartement(DemandeTeleTravail demande) {
		demandeTeleTravailRepository.save(demande);
		return demande.getId();
	}

	@Override
	public void supprimerDemandeTeleTravail(Long demandeId) {
		demandeTeleTravailRepository.deleteById(demandeId);
	}

	@Override
	public List<DemandeTeleTravail> getDemandeTeleTravails() {
		return demandeTeleTravailRepository.findAll();
	}

	@Override
	public DemandeTeleTravail getDemandeTeleTravailById(Long demandeId) {
		return demandeTeleTravailRepository.findById(demandeId).get();
	}

}
