package tn.esprit.happyemployee.domain.comparator;

import java.util.Comparator;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import tn.esprit.happyemployee.domain.utilities.DateUtility;
import tn.esprit.happyemployee.entities.DemandeTeleTravail;
import tn.esprit.happyemployee.repositories.DemandeTeleTravailRepository;

public class NbDayMonthComparator implements Comparator<DemandeTeleTravail> {
	
	@Autowired
	DemandeTeleTravailRepository demandeTeleTravailRepository;
	
    @Override
    public int compare(DemandeTeleTravail o1, DemandeTeleTravail o2) {
    	DateUtility dateUtility = new DateUtility();
    	
    	Date startDate = dateUtility.getFirstDateOfMonth(o1.getDateDemande());
    	Date endDate = dateUtility.getLastDateOfMonth(o1.getDateDemande());
    	
    	long val1 = demandeTeleTravailRepository.getDemndeCountPerEmployee(startDate, endDate, o1.getUser());
    	
        startDate = dateUtility.getFirstDateOfMonth(o2.getDateDemande());
    	endDate = dateUtility.getLastDateOfMonth(o2.getDateDemande());
    	
    	long val2 = demandeTeleTravailRepository.getDemndeCountPerEmployee(startDate, endDate, o2.getUser());
        return (int) (val1 - val2);
    }
}
