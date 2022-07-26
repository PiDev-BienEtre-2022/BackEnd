package tn.esprit.happyemployee.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.happyemployee.domain.enums.DemandeApprove;
import tn.esprit.happyemployee.domain.enums.DemandeUrgency;
import tn.esprit.happyemployee.domain.enums.FilterPeriode;
import tn.esprit.happyemployee.domain.enums.FilterTyp;
import tn.esprit.happyemployee.domain.enums.RunSchedule;
import tn.esprit.happyemployee.domain.utilities.DateUtility;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.entities.Equipe;
import tn.esprit.happyemployee.entities.FilterTeletravail;
import tn.esprit.happyemployee.entities.User;
import tn.esprit.happyemployee.repositories.DemandeTeleTravailRepository;
import tn.esprit.happyemployee.repositories.UserRepository;


@Service
public class DemandeTeleTravailService implements IDemandeTeleTravailService {

	@Autowired
	DemandeTeleTravailRepository demandeTeleTravailRepository;
	
	@Autowired
	UserRepository userRepository;
	
	
	@Override
	public Long addDemandeTeleTravail(DemandeTeleTravail demande,Long userId) {
		User user = userRepository.findById(userId).get();
		demande.setUser(user);
		FilterTeletravail filter = getFilterbyDemande(demande);
		if(filter.getRunSchedule() != RunSchedule.eachDemande) {
			demande.setSystemApprove(DemandeApprove.waiting);
			demande.setManagerApprove(DemandeApprove.waiting);
		}
		else {
			demande = processSystemLogic(demande, filter);
		}
		
		demandeTeleTravailRepository.save(demande);
		return demande.getId();
	}

	@Override
	public Long modifierDemandeTeleTravail(DemandeTeleTravail demande) {
		DemandeTeleTravail dm = demandeTeleTravailRepository.findById(demande.getId()).get();
		dm.setManagerApprove(demande.getManagerApprove());
		dm.setNoteManager(demande.getNoteManager());
		demandeTeleTravailRepository.save(dm);
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

	@Override
	public List<DemandeTeleTravail> getDemandebyUser(Long userId) {
		User user = userRepository.findById(userId).get();
		return demandeTeleTravailRepository.getDemandesByUser(user);
	}

	@Override
	public FilterTeletravail getFilterbyDemande(DemandeTeleTravail demande) {
		Equipe equipe = demande.getUser().getEquipe();
		if(equipe.getFiltre() != null) {
			return equipe.getFiltre();
		}
		else {
			return equipe.getDepartement().getFiltre();
		}
	}

	@Override
	public DemandeTeleTravail processSystemLogic(DemandeTeleTravail demande, FilterTeletravail filter) {

		boolean accept = isDemandeAccepted(demande,filter);
		
		if(accept) {
			demande.setSystemApprove(DemandeApprove.approved);
		}
		else {
			demande.setSystemApprove(DemandeApprove.rejected);
		}
		
		switch(filter.getCommitLogic()) {
		  case none:
			  demande.setManagerApprove(DemandeApprove.waiting);
			  break;
		  case all:
			  demande.setManagerApprove(demande.getSystemApprove());
			  break;
		  case onlyAccept:
			  if(accept) {
				demande.setManagerApprove(DemandeApprove.approved);
			  }
			  else {
				demande.setManagerApprove(DemandeApprove.waiting);
			  }
			  break;
		  case onlyRefus:
			  if(accept) {
				demande.setManagerApprove(DemandeApprove.waiting);
			  }
			  else {
				  if(Boolean.TRUE.equals(demande.getExtra()))
					{
						demande.setSystemApprove(DemandeApprove.waiting);
						
					}else {
						demande.setSystemApprove(DemandeApprove.rejected);
					}
			  }
			  break;
		  case refusNotUrgent:
			  if(!accept && demande.getUrgency() == DemandeUrgency.notUrgent) {
				  if(Boolean.TRUE.equals(demande.getExtra()))
					{
						demande.setSystemApprove(DemandeApprove.waiting);
						
					}else {
						demande.setSystemApprove(DemandeApprove.rejected);
					}
			  }
			  else {
				demande.setManagerApprove(DemandeApprove.waiting);
			  }
			  break;
		  case refusUrgentAndLess:
			  if(!accept && demande.getUrgency() != DemandeUrgency.veryUrgent) {
				  if(Boolean.TRUE.equals(demande.getExtra()))
					{
						demande.setSystemApprove(DemandeApprove.waiting);
						
					}else {
						demande.setSystemApprove(DemandeApprove.rejected);
					}
			  }
			  else {
				demande.setManagerApprove(DemandeApprove.waiting);
			  }
			  break;
		  case refusWithNoNote:
			  if(!accept && demande.getNoteEmp() == "") {
				  if(Boolean.TRUE.equals(demande.getExtra()))
					{
						demande.setSystemApprove(DemandeApprove.waiting);
						
					}else {
						demande.setSystemApprove(DemandeApprove.rejected);
					}
			  }
			  else {
				demande.setManagerApprove(DemandeApprove.waiting);
			  }
			  break;
		  default:
			  demande.setManagerApprove(DemandeApprove.waiting);
		}
		return demande;
	}

	@Override
	public Long getDemndeCountPerEmployee(Date startDate, Date endDate, User user) {
		return demandeTeleTravailRepository.getDemndeCountPerEmployee(startDate, endDate, user);
	}

	@Override
	public Long getDemndeCountPerEquipe(Date startDate, Date endDate, Equipe equipe) {
		return demandeTeleTravailRepository.getDemndeCountPerEquipe(startDate, endDate, equipe);
	}
	

	@Override
	public boolean isDemandeAccepted(DemandeTeleTravail demande, FilterTeletravail filter) {
		
		DateUtility dateUtility = new DateUtility();
		
		if(filter.getEqPeriode() != null) {
			
			Date startDate ;
			Date endDate;
			
			if(filter.getEqPeriode() == FilterPeriode.week) {
				startDate = dateUtility.getFirstDateOfWeek(demande.getDateDemande());
				endDate = dateUtility.getLastDateOfWeek(demande.getDateDemande());
			}
			else {
				startDate = dateUtility.getFirstDateOfMonth(demande.getDateDemande());
				endDate = dateUtility.getLastDateOfMonth(demande.getDateDemande());
			}
			
			
			Long result = getDemndeCountPerEquipe(startDate, endDate, demande.getUser().getEquipe());
			
			if(filter.getEqFilterType() == FilterTyp.fstatic) {
				return result < filter.getEqMetrique();
			}
			else {
				Long nbrUser = userRepository.getUserCountPerEquipe(demande.getUser().getEquipe());
				return result < (filter.getEqMetrique() * nbrUser) / 100  ;
			}
		}
		else {
			Date startDate ;
			Date endDate;
			
			if(filter.getEpPeriode() == FilterPeriode.week) {
				startDate = dateUtility.getFirstDateOfWeek(demande.getDateDemande());
				endDate = dateUtility.getLastDateOfWeek(demande.getDateDemande());
			}
			else {
				startDate = dateUtility.getFirstDateOfMonth(demande.getDateDemande());
				endDate = dateUtility.getLastDateOfMonth(demande.getDateDemande());
			}

			Long result = getDemndeCountPerEmployee(startDate, endDate, demande.getUser());
			
			return result < filter.getEpMetrique();
		}
	}

	@Override
	public List<DemandeTeleTravail> getDemandeTeleTravailsByEquipeId(Long equipeID) {
		return demandeTeleTravailRepository.findByEquipeId(equipeID);
	}
}
