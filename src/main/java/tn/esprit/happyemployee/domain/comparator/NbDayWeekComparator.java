package tn.esprit.happyemployee.domain.comparator;

import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.happyemployee.domain.utilities.DateUtility;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.repositories.DemandeTeleTravailRepository;

public class NbDayWeekComparator  implements Comparator<DemandeTeleTravail> {
	
	@Autowired
	DemandeTeleTravailRepository demandeTeleTravailRepository;
	
    @Override
    public int compare(DemandeTeleTravail o1, DemandeTeleTravail o2) {
    	DateUtility dateUtility = new DateUtility();
    	
    	Date startDate = dateUtility.getFirstDateOfWeek(o1.getDateDemande());
    	Date endDate = dateUtility.getLastDateOfWeek(o1.getDateDemande());
    	
    	long val1 = demandeTeleTravailRepository.getDemndeCountPerEmployee(startDate, endDate, o1.getUser());
    	
        startDate = dateUtility.getFirstDateOfWeek(o2.getDateDemande());
    	endDate = dateUtility.getLastDateOfWeek(o2.getDateDemande());
    	
    	long val2 = demandeTeleTravailRepository.getDemndeCountPerEmployee(startDate, endDate, o2.getUser());
        return (int) (val1 - val2);
    }
}
